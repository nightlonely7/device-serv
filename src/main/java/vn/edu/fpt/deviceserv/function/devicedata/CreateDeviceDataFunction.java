package vn.edu.fpt.deviceserv.function.devicedata;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import vn.edu.fpt.deviceserv.dto.request.DeviceDataRequest;
import vn.edu.fpt.deviceserv.service.DeviceDataService;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateDeviceDataFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper objectMapper;
    private final DeviceDataService deviceDataService;

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        System.out.println(apiGatewayProxyRequestEvent);
        DeviceDataRequest deviceDataRequest = objectMapper.readValue(apiGatewayProxyRequestEvent.getBody(), DeviceDataRequest.class);
        System.out.println(deviceDataRequest);
        deviceDataService.createDeviceData(deviceDataRequest);
        return new APIGatewayProxyResponseEvent()
                .withBody(objectMapper.writeValueAsString(deviceDataRequest))
                .withStatusCode(201);
    }
}
