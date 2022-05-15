package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.deviceserv.dto.entity.ParamItem;

import java.util.List;

public interface ParamItemRepository extends JpaRepository<ParamItem, Long> {
    List<ParamItem> findAllByType(String type);
}
