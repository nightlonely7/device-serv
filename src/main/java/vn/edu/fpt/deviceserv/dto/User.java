package vn.edu.fpt.deviceserv.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "permission")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    @ManyToMany
    private List<Permission> permissions;
}
