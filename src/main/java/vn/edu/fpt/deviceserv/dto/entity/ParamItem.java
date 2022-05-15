package vn.edu.fpt.deviceserv.dto.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Data
@Entity
@Table(name = "param_item")
@TypeDef(name = "json", typeClass = JsonType.class)
public class ParamItem {
    @Id
    private Long id;
    private String name;
    private String type;
    @Type(type = "json")
    private Map<String, String> params;
}
