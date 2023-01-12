package digital.pharma.packml.domain.mapper;

import digital.pharma.packml.domain.model.Component;
import digital.pharma.packml.infra.entity.ComponentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ComponentMapper extends IMap {

    ComponentMapper INSTANCE = Mappers.getMapper(ComponentMapper.class);

    Component toModel(ComponentEntity entity);
    Set<Component> toModelList(Iterable<ComponentEntity> entities);
    @Mapping(target = "properties", expression = "java(mapFromHash(model.getProperties()))")
    ComponentEntity toEntity(Component model);

}
