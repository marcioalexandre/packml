package digital.pharma.packml.app.mapper;

import digital.pharma.packml.app.dto.PropertyDTO;
import digital.pharma.packml.domain.model.Property;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface PropertyDTOMapper {

    PropertyDTOMapper INSTANCE = Mappers.getMapper(PropertyDTOMapper.class);
    Property toModel(PropertyDTO dto);
    PropertyDTO toDTO(Property domain);
    Set<PropertyDTO> toDTOList(Set<Property> domains);
}
