package digital.pharma.packml.app.mapper;

import digital.pharma.packml.app.dto.ComponentDTO;
import digital.pharma.packml.domain.model.Component;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ComponentDTOMapper {

    ComponentDTOMapper INSTANCE = Mappers.getMapper(ComponentDTOMapper.class);

    Component toModel(ComponentDTO componentDTO);
    Set<Component> toModelList(Set<ComponentDTO> dtos);
    ComponentDTO toDTO(Component component);
    Set<ComponentDTO> toDTOList(Set<Component> components);
}
