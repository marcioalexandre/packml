package digital.pharma.packml.app.mapper;

import digital.pharma.packml.app.dto.ClusterDTO;
import digital.pharma.packml.domain.model.Cluster;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface ClusterDTOMapper {

    ClusterDTOMapper INSTANCE = Mappers.getMapper(ClusterDTOMapper.class);

    ClusterDTO toDTO(Cluster model);
    Cluster toModel(ClusterDTO clusterDTO);
    Set<Cluster> toModelList(Set<ClusterDTO> dtos);
}
