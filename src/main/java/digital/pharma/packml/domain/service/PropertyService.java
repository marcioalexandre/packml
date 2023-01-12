package digital.pharma.packml.domain.service;

import digital.pharma.packml.domain.mapper.PropertyMapper;
import digital.pharma.packml.domain.model.Property;
import digital.pharma.packml.infra.db.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository repo;
    PropertyMapper mapper = PropertyMapper.INSTANCE;

    @Transactional
    public Property create(Property component){
        return mapper.toModel(repo.save(mapper.toEntity(component)));
    }

    public Set<Property> getAll(){
        return mapper.toModelList(repo.findAll());
    }

    public Property getById(Long id){
        return mapper.toModel(repo.findById(id).orElse(null));
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
