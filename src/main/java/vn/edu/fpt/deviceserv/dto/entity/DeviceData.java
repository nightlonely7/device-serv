package vn.edu.fpt.deviceserv.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "device_data")
public class DeviceData {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;
    private String label;
    private String value;
    private LocalDateTime createdAt;
}
