package vn.edu.fpt.deviceserv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.fpt.deviceserv.dto.Device;
import vn.edu.fpt.deviceserv.dto.DeviceData;
import vn.edu.fpt.deviceserv.repository.DeviceDataRepository;
import vn.edu.fpt.deviceserv.repository.DeviceRepository;
import vn.edu.fpt.deviceserv.service.DeviceService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceDataRepository deviceDataRepository;

    @Override
    public void createDevice(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public List<Device> listDevice() {
        return deviceRepository.findAll();
    }

    @Override
    public void saveDeviceData(DeviceData deviceData) {
        deviceDataRepository.save(deviceData);
    }
}
