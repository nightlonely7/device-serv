package vn.edu.fpt.deviceserv.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "device_data")
public class DeviceData {
    @Id
    private Long id;
    private Long deviceId;
    private String label;
    private String value;
}
