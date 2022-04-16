package vn.edu.fpt.deviceserv.function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReverseStringFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
        return new APIGatewayProxyResponseEvent()
                .withBody(new StringBuilder(request.getBody()).reverse().toString())
                .withStatusCode(200);
    }
}
