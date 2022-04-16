package vn.edu.fpt.deviceserv.function.device;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import vn.edu.fpt.deviceserv.dto.Device;
import vn.edu.fpt.deviceserv.service.DeviceService;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ListDeviceFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper objectMapper;
    private final DeviceService deviceService;

    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent) {
        List<Device> deviceList = deviceService.listDevice();
        System.out.println(deviceList);
        return new APIGatewayProxyResponseEvent()
                .withBody(objectMapper.writeValueAsString(deviceList))
                .withStatusCode(200);
    }
}
