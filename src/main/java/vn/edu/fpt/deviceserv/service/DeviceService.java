package vn.edu.fpt.deviceserv.service;

import vn.edu.fpt.deviceserv.dto.Device;

import java.util.List;

public interface DeviceService {
    void createDevice(Device device);
    List<Device> listDevice();
}
