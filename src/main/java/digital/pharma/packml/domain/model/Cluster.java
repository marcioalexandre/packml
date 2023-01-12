package digital.pharma.packml.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

@Data
@Builder
public class Cluster
        implements Serializable, GenericModel<Cluster> {

    private Long id;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "description cannot be null")
    private String description;
    private Long clusterId;
    private Set<Component> components;
    private Set<Cluster> clusters;
    private Set<HashMap<String, String>> properties;

    @Override
    public void update(Cluster source) {
        this.id = source.getId();
        this.name = source.getName();
        this.clusterId = source.getClusterId();
        this.components = source.getComponents();
        this.clusters = source.getClusters();
        this.properties = source.getProperties();
    }

    @Override
    public Cluster createnewInstance() {
        Cluster newInstance = Cluster.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
