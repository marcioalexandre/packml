package digital.pharma.packml.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Set;

@Data
@Builder
public class ClusterDTO {

    private Long clusterId;
    private String name;
    private String description;
    private Set<ComponentDTO> components;
    private Set<ClusterDTO> clusters;
    private Set<HashMap<String, String>> properties;
}
