package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.fpt.deviceserv.dto.entity.Device;
import vn.edu.fpt.deviceserv.dto.entity.DeviceData;

import java.util.List;

public interface DeviceDataRepository extends JpaRepository<DeviceData, Long> {
    @Query("select dd from DeviceData dd where dd.device = :device and (dd.label, dd.createdAt) in " +
            "(select dd.label, max(dd.createdAt) from DeviceData dd group by dd.label)")
    List<DeviceData> findFirstByDevice(@Param("device") Device device);
}
