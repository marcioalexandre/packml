package digital.pharma.packml.infra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="cluster", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterEntity
        implements Serializable, GenericEntity<ClusterEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(name = "cluster_id")
    private Long clusterId;

    // Hibernate relations
    @OneToMany(mappedBy = "clusterId")
    private Set<ComponentEntity> components;
    @OneToMany(mappedBy = "clusterId")
    private Set<ClusterEntity> clusters;
    @OneToMany(mappedBy = "parentId")
    private Set<PropertyEntity> properties;

    @Override
    public void update(ClusterEntity source) {
        this.name = source.getName();
        this.description = source.getName();
        this.clusterId = source.getClusterId();
        this.components = source.getComponents();
        this.clusters = source.getClusters();
        this.properties = source.getProperties();
    }

    @Override
    public ClusterEntity createNewInstance() {
        ClusterEntity newInstance = ClusterEntity.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
