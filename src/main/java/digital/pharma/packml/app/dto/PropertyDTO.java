package digital.pharma.packml.app.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PropertyDTO
        implements Serializable, GenericDTO<PropertyDTO> {

    // private Long id;
    private Long parentId;
    private String type;
    private String name;
    private String value;


    @Override
    public void update(PropertyDTO source) {
        // this.id = source.getId();
        this.parentId = source.getParentId();
        this.type = source.getType();
        this.name = source.getName();
        this.value = source.getValue();
    }

    @Override
    public PropertyDTO createNewInstance() {
        PropertyDTO newInstance = PropertyDTO.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
