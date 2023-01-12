package digital.pharma.packml.infra.db.repository;

import digital.pharma.packml.infra.entity.ClusterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends GenericRepository<ClusterEntity>{

    @Query(value = "SELECT * FROM cluster c WHERE c.cluster_id is null", nativeQuery = true)
    ClusterEntity findRootCluster();
}
