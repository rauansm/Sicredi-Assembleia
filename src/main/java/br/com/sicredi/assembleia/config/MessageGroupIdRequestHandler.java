package br.com.sicredi.assembleia.config;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.services.sns.model.PublishRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MessageGroupIdRequestHandler extends RequestHandler2 {

    @Override
    public AmazonWebServiceRequest beforeExecution(AmazonWebServiceRequest request) {
        AmazonWebServiceRequest amazonWebServiceRequest = super.beforeExecution(request);
        if (amazonWebServiceRequest instanceof PublishRequest) {
            PublishRequest publishRequest = (PublishRequest) amazonWebServiceRequest;
            log.debug("[SENDING] message with value {} to topic {}", publishRequest.getMessage(), publishRequest.getTopicArn());
        }
        return amazonWebServiceRequest;
    }
}
