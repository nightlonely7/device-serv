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
public class Permission {
    @Id
    private Long id;
    private String functionSignature;
    @ManyToMany
    private List<User> users;
}
