package vn.edu.fpt.deviceserv.dto;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "device")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Device {
    @Id
    private Long id;
    private Long stationId;
    private String name;
    private Integer addressBit;
    @Type(type = "json")
    private List<DeviceLabel> labels;
}
