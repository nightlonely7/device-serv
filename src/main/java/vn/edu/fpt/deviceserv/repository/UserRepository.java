package vn.edu.fpt.deviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.deviceserv.dto.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
