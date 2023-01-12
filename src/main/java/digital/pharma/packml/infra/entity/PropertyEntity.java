package digital.pharma.packml.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="property", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyEntity
        implements Serializable, GenericEntity<PropertyEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "parent_id")
    private long parentId;
    private String type;
    @Column(unique = true)
    private String name;
    private String value;

    @Override
    public void update(PropertyEntity source) {
        this.parentId = source.getParentId();
        this.type = source.getType();
        this.name = source.getName();
        this.value = source.getValue();
    }

    @Override
    public PropertyEntity createNewInstance() {
        PropertyEntity newInstance = PropertyEntity.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
