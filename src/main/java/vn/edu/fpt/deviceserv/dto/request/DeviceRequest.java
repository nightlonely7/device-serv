package vn.edu.fpt.deviceserv.dto.request;

import lombok.Data;
import vn.edu.fpt.deviceserv.dto.entity.DeviceLabel;

import java.util.List;

@Data
public class DeviceRequest {
    private Long id;
    private Long stationId;
    private String name;
    private Integer addressBit;
    private List<DeviceLabel> labels;
}
