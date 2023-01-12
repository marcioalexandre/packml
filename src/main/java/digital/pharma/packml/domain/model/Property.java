package digital.pharma.packml.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class Property
        implements Serializable, GenericModel<Property> {

    private Long id;
    @NotNull(message = "parent id cannot be null")
    private Long parentId;
    @NotNull(message = "type cannot be null")
    private String type;
    @NotNull(message = "name cannot be null")
    private String name;
    private String value;

    @Override
    public void update(Property source) {
        this.id = source.getId();
        this.parentId = source.getParentId();
        this.type = source.getType();
        this.name = source.getName();
        this.value = source.getValue();
    }

    @Override
    public Property createnewInstance() {
        Property newInstance = Property.builder().build();
        newInstance.update(this);
        return newInstance;
    }
}
