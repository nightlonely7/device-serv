package vn.edu.fpt.deviceserv.service;

import vn.edu.fpt.deviceserv.dto.entity.Device;
import vn.edu.fpt.deviceserv.dto.entity.DeviceData;
import vn.edu.fpt.deviceserv.dto.request.DeviceRequest;

import java.util.List;

public interface DeviceService {
    void createDevice(DeviceRequest deviceRequest);
    List<Device> listDevice();
}
