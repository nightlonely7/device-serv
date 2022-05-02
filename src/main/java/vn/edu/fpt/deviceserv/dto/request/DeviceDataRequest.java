package vn.edu.fpt.deviceserv.dto.request;

import lombok.Data;

@Data
public class DeviceDataRequest {
    private Long deviceId;
    private String label;
    private String value;
}
