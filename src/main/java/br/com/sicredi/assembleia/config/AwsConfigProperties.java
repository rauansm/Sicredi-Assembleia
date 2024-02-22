package br.com.sicredi.assembleia.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "aws.config")
@ToString
public class AwsConfigProperties {
    private String region;
    private String accesskey;
    private String secretkey;
    private String endpointuri;
    private String resultadoSessaoTopic;
}
