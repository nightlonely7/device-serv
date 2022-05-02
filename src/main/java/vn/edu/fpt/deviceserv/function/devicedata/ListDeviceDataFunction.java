package vn.edu.fpt.deviceserv.function.devicedata;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import vn.edu.fpt.deviceserv.dto.entity.DeviceData;
import vn.edu.fpt.deviceserv.service.DeviceDataService;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ListDeviceDataFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper objectMapper;
    private final DeviceDataService deviceDataService;

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        String deviceId = apiGatewayProxyRequestEvent.getQueryStringParameters().get("deviceId");
        List<DeviceData> deviceDataList = deviceDataService.listDeviceDataById(Long.parseLong(deviceId));
        System.out.println(deviceDataList);
        return new APIGatewayProxyResponseEvent()
                .withBody(objectMapper.writeValueAsString(deviceDataList))
                .withStatusCode(200);
    }
}
