package vn.edu.fpt.deviceserv.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "device")
public class Device {
    @Id
    private String id;
    private String name;
    private String signature;
}
