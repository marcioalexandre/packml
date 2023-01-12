package digital.pharma.packml.domain.mapper;

import digital.pharma.packml.domain.model.Cluster;
import digital.pharma.packml.infra.entity.ClusterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ClusterMapper extends IMap {

    ClusterMapper INSTANCE = Mappers.getMapper(ClusterMapper.class);

    @Mapping(target = "properties", expression = "java(mapFromEntity(entity.getProperties(), \"cluster\"))")
    Cluster toModel(ClusterEntity entity);
    Set<Cluster> toModelList(Iterable<ClusterEntity> entities);
    @Mapping(target = "properties", expression = "java(mapFromHash(model.getProperties()))")
    ClusterEntity toEntity(Cluster model);
}
