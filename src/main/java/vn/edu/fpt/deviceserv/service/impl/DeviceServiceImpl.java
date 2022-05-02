package vn.edu.fpt.deviceserv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.fpt.deviceserv.dto.entity.Device;
import vn.edu.fpt.deviceserv.dto.request.DeviceRequest;
import vn.edu.fpt.deviceserv.repository.DeviceRepository;
import vn.edu.fpt.deviceserv.repository.StationRepository;
import vn.edu.fpt.deviceserv.service.DeviceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final StationRepository stationRepository;

    @Override
    public void createDevice(DeviceRequest deviceRequest) {
        Device device = new Device();
        device.setName(deviceRequest.getName());
        device.setAddressBit(deviceRequest.getAddressBit());
        device.setStation(stationRepository.getById(deviceRequest.getStationId()));
        device.setLabels(deviceRequest.getLabels());
        deviceRepository.save(device);
    }

    @Override
    public List<Device> listDevice() {
        return deviceRepository.findAll();
    }
}
