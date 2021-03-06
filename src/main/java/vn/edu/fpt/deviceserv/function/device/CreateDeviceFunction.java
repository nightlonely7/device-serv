package vn.edu.fpt.deviceserv.function.device;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import vn.edu.fpt.deviceserv.dto.request.DeviceRequest;
import vn.edu.fpt.deviceserv.service.DeviceService;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateDeviceFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper objectMapper;
    private final DeviceService deviceService;

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        System.out.println(apiGatewayProxyRequestEvent);
        DeviceRequest deviceRequest = objectMapper.readValue(apiGatewayProxyRequestEvent.getBody(), DeviceRequest.class);
        System.out.println(deviceRequest);
        deviceService.createDevice(deviceRequest);
        return new APIGatewayProxyResponseEvent()
                .withBody(objectMapper.writeValueAsString(deviceRequest))
                .withStatusCode(201);
    }
}
