package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.deviceserv.dto.DeviceData;

public interface DeviceDataRepository extends JpaRepository<DeviceData, Long> {
}
