package vn.edu.fpt.deviceserv.service;

import org.springframework.data.repository.query.Param;
import vn.edu.fpt.deviceserv.dto.entity.DeviceData;
import vn.edu.fpt.deviceserv.dto.request.DeviceDataRequest;

import java.util.List;

public interface DeviceDataService {
    void createDeviceData(DeviceDataRequest deviceDataRequest);
    List<DeviceData> listDeviceDataById(@Param("deviceId") Long deviceId);
}
