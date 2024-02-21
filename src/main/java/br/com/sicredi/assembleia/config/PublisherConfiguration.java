package br.com.sicredi.assembleia.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
@Configuration
@RequiredArgsConstructor
@Log4j2
public class PublisherConfiguration {
    @Value("${app.aws.endpoint-override:#{null}}")
    private Optional<String> endpointUrl;
    @Value("${cloud.aws.region.static:#{null}}")
    private Optional<String> region;

    private final AwsConfigProperties awsSnsProperties;
    private final MessageGroupIdRequestHandler messageGroupIdRequestHandler;

    @Bean
    public AmazonSNS amazonSNS() {
        log.debug("[start] PublisherConfiguration - amazonSNS");
        log.debug("[awsSnsProperties] {}",awsSnsProperties);
        AmazonSNSAsyncClientBuilder clientBuilder = AmazonSNSAsyncClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsSnsProperties.getAccesskey(), awsSnsProperties.getSecretkey())))
                .withRequestHandlers(messageGroupIdRequestHandler);
        addUrl(clientBuilder);
        AmazonSNSAsync clientSNS = clientBuilder.build();
        log.debug("[finish] PublisherConfiguration - amazonSNS");
        return clientSNS;
    }

    private void addUrl(AmazonSNSAsyncClientBuilder clientBuilder) {
        endpointUrl
                .map(url -> new AwsClientBuilder.EndpointConfiguration(url, region.orElse(DEFAULT_REGION)))
                .ifPresentOrElse(clientBuilder::withEndpointConfiguration, ()-> {
                    region.ifPresent(clientBuilder::withRegion);
                });
    }

    @Bean
    @Autowired
    public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS) {
        return new NotificationMessagingTemplate(amazonSNS);
    }
    private static final String DEFAULT_REGION = "us-east-1";
}
