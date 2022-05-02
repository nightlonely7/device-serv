package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.deviceserv.dto.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    boolean existsByUsers_UsernameAndFunctionSignature(String username, String functionSignature);
}
