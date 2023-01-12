package digital.pharma.packml.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

@Data
@Builder
public class Component
        implements Serializable, GenericModel<Component> {

    @NotNull(message = "parameter id cannot be null")
    private Long id;
    @NotNull(message = "parent cluster id cannot be null")
    private Long clusterId;
    @NotBlank(message = "url cannot be empty")
    private String url;
    @NotNull(message = "machine number cannot be null")
    private Integer machineNumber;
    @NotNull(message = "name cannot be null")
    private String name;
    private Set<HashMap<String, String>> properties;

    @Override
    public void update(Component source) {
        this.id = source.getId();
        this.clusterId = source.getId();
        this.url = source.getUrl();
        this.machineNumber = source.getMachineNumber();
        this.name = source.getName();
        this.properties = source.getProperties();
    }

    @Override
    public Component createnewInstance() {
        Component newInstance = Component.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
