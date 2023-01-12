package digital.pharma.packml.domain.service;

import digital.pharma.packml.domain.mapper.ComponentMapper;
import digital.pharma.packml.domain.model.Component;
import digital.pharma.packml.infra.db.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class ComponentService {

    @Autowired
    ComponentRepository repo;
    ComponentMapper mapper = ComponentMapper.INSTANCE;

    @Transactional
    public Component create(Component component){
        return mapper.toModel(repo.save(mapper.toEntity(component)));
    }


    public Set<Component> getAll(){
        return mapper.toModelList(repo.findAll());
    }

    public Component getById(Long id){
        return mapper.toModel(repo.findById(id).orElse(null));
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
