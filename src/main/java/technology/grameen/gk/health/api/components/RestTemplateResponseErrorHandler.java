package technology.grameen.gk.health.api.components;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import technology.grameen.gk.health.api.exceptions.CustomException;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
        || clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if(clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR){
            // handle Server error
        }else if(clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR){
            if(clientHttpResponse.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY){
                //throw new Exception(clientHttpResponse.getBody().toString());
            }
        }
    }
}
