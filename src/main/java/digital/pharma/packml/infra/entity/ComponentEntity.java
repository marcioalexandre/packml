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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="component", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentEntity
       implements Serializable, GenericEntity<ComponentEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="cluster_id")
    private long clusterId;
    private String name;
    private String url;
    @Column(name = "machine_number")
    private long machineNumber;
    @OneToMany(mappedBy = "parentId")
    private Set<PropertyEntity> properties;

    @Override
    public void update(ComponentEntity source) {
        this.clusterId = source.getClusterId();
        this.name = source.getName();
        this.url = source.getUrl();
        this.machineNumber = source.getMachineNumber();
        this.properties = source.getProperties();
    }

    @Override
    public ComponentEntity createNewInstance() {
        ComponentEntity newInstance = ComponentEntity.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
