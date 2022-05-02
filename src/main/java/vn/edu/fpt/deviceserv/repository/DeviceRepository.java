package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.deviceserv.dto.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
