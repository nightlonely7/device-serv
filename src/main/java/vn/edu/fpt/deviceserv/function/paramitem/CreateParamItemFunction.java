package vn.edu.fpt.deviceserv.function.paramitem;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import vn.edu.fpt.deviceserv.dto.entity.ParamItem;
import vn.edu.fpt.deviceserv.service.ParamItemService;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateParamItemFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper objectMapper;
    private final ParamItemService paramItemService;

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        System.out.println(apiGatewayProxyRequestEvent);
        ParamItem paramItem = objectMapper.readValue(apiGatewayProxyRequestEvent.getBody(), ParamItem.class);
        System.out.println(paramItem);
        paramItemService.createParamItem(paramItem);
        return new APIGatewayProxyResponseEvent()
                .withBody(objectMapper.writeValueAsString(paramItem))
                .withStatusCode(201);
    }
}
