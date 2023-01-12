package digital.pharma.packml.domain.service;

import digital.pharma.packml.domain.model.Cluster;
import digital.pharma.packml.infra.db.repository.ClusterRepository;
import digital.pharma.packml.infra.entity.ClusterEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClusterServiceTest {

    @MockBean
    private ClusterService service;
    @MockBean
    private ClusterRepository mockRepo;
    Long id = Long.parseLong("1234");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getById_withValidId() throws Exception {
        when(mockRepo.findById(any()))
                .thenReturn(Optional.ofNullable(getAValidClusterEntity(id)));
        Cluster cluster  = service.getById(id);
        assertEquals(id, cluster.getId());
    }

    @Test
    void persist() {
    }

    @Test
    void getAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getRoot() {
    }

    private ClusterEntity getAValidClusterEntity(Long id) {
        return ClusterEntity.builder()
                .id(id)
                .name("cluster 1")
                .description("any cluster")
                .build();
    }
}