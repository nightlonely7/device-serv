package vn.edu.fpt.deviceserv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.fpt.deviceserv.dto.entity.DeviceData;
import vn.edu.fpt.deviceserv.dto.request.DeviceDataRequest;
import vn.edu.fpt.deviceserv.repository.DeviceDataRepository;
import vn.edu.fpt.deviceserv.repository.DeviceRepository;
import vn.edu.fpt.deviceserv.service.DeviceDataService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceDataServiceImpl implements DeviceDataService {

    private final DeviceDataRepository deviceDataRepository;
    private final DeviceRepository deviceRepository;

    @Override
    public void createDeviceData(DeviceDataRequest deviceDataRequest) {
        DeviceData deviceData = new DeviceData();
        deviceData.setDevice(deviceRepository.getById(deviceDataRequest.getDeviceId()));
        deviceData.setLabel(deviceDataRequest.getLabel());
        deviceData.setValue(deviceDataRequest.getValue());
        deviceDataRepository.save(deviceData);
    }

    @Override
    public List<DeviceData> listDeviceDataById(Long deviceId) {
        return deviceDataRepository.findFirstByDevice(deviceRepository.getById(deviceId));
    }
}
