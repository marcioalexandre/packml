package digital.pharma.packml.domain.service;

import digital.pharma.packml.domain.mapper.ClusterMapper;
import digital.pharma.packml.domain.model.Cluster;
import digital.pharma.packml.infra.broker.service.RabbitMQProducer;
import digital.pharma.packml.infra.db.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {

    @Autowired
    ClusterRepository repo;
    @Autowired
    RabbitMQProducer producer;
    ClusterMapper mapper = ClusterMapper.INSTANCE;

    public Cluster update(Cluster cluster) throws Exception {
        return create(cluster);
    }

    public Cluster getById(Long id) throws Exception {
        try {
            return mapper.toModel(repo.findById(id).get());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Cluster create(Cluster cluster) throws Exception {
        Cluster savedCluster = Cluster.builder().build();
        try{
            savedCluster = mapper.toModel(repo.save(mapper.toEntity(cluster)));
            this.sendToBroker(savedCluster);
            return savedCluster;
        } catch (Exception e) {
            if (savedCluster.getId() != null)
                deleteById(savedCluster.getId());
            throw new Exception("[Error] creating cluster. " + e.getMessage());
        }
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public Cluster getRoot(){
        return mapper
                .toModel(repo.findRootCluster());
    }

    private void sendToBroker(Cluster cluster) throws Exception {
        try {
            producer.send(Long.toString(cluster.getId()));
            if (cluster.getClusters() != null) {
                cluster.getClusters().forEach(c -> {
                    try {
                        sendToBroker(c);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }catch (Exception e){
            throw new Exception("[Error] rabbitmq. " + e.getMessage());
        }
    }
}
