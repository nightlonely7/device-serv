package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.deviceserv.dto.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
}
