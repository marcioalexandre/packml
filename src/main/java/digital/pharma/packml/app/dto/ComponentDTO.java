package digital.pharma.packml.app.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

@Data
@Builder
public class ComponentDTO
        implements Serializable, GenericDTO<ComponentDTO> {

    private Long clusterId;
    private String url;
    private Integer machineNumber;
    private String name;
    private Set<HashMap<String, String>> properties;


    @Override
    public void update(ComponentDTO source) {
        this.clusterId = source.getClusterId();
        this.url = source.getUrl();
        this.machineNumber = source.getMachineNumber();
        this.name = source.getName();
        this.properties = source.getProperties();
    }

    @Override
    public ComponentDTO createNewInstance() {
        ComponentDTO newInstance = ComponentDTO.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
