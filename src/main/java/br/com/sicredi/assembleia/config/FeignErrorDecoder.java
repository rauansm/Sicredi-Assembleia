package br.com.sicredi.assembleia.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static java.lang.String.format;

public class FeignErrorDecoder implements ErrorDecoder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = format("An error occurred while calling the API. Status code: {0}, methodKey: {1}",
                response.status(), methodKey);
        if (response.status() == HttpStatus.NOT_FOUND.value())
            LOGGER.warn(message);
        else LOGGER.error(message);
        try {
            return new ResponseStatusException(HttpStatus.valueOf(response.status()), response.reason());
        } catch (Exception e) {
            return new Exception("Status code: " + response.status()
                    + ", methodKey:" + methodKey.replaceAll("\\(.*\\)", ""));
        }
    }
}
