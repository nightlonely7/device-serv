package vn.edu.fpt.deviceserv.dto.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "station")
public class Station {
    @Id
    private Long id;
    private String name;
}
