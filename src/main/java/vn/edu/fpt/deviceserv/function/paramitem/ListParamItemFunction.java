package vn.edu.fpt.deviceserv.function.paramitem;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import vn.edu.fpt.deviceserv.dto.entity.ParamItem;
import vn.edu.fpt.deviceserv.service.ParamItemService;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ListParamItemFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper objectMapper;
    private final ParamItemService paramItemService;

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        String type = apiGatewayProxyRequestEvent.getQueryStringParameters().get("type");
        List<ParamItem> paramItemList = paramItemService.listParamItemByType(type);
        System.out.println(paramItemList);
        return new APIGatewayProxyResponseEvent()
                .withBody(objectMapper.writeValueAsString(paramItemList))
                .withStatusCode(200);
    }
}
