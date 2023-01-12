package digital.pharma.packml.domain.mapper;

import digital.pharma.packml.domain.model.Property;
import digital.pharma.packml.infra.entity.PropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface PropertyMapper {

    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    Property toModel(PropertyEntity entity);
    Set<Property> toModelList(Iterable<PropertyEntity> entities);
    PropertyEntity toEntity(Property model);
}
