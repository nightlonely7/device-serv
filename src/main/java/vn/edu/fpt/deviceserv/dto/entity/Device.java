package vn.edu.fpt.deviceserv.dto.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    private Station station;
    private String name;
    private Integer addressBit;
    @Type(type = "json")
    private List<DeviceLabel> labels;
}
