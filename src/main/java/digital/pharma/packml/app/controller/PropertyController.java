package digital.pharma.packml.app.controller;

import digital.pharma.packml.app.dto.PropertyDTO;
import digital.pharma.packml.app.mapper.PropertyDTOMapper;
import digital.pharma.packml.domain.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("property/v1")
public class PropertyController {

    @Autowired
    PropertyService service;
    PropertyDTOMapper mapper = PropertyDTOMapper.INSTANCE;

    @PutMapping
    public ResponseEntity<PropertyDTO> update(@RequestBody PropertyDTO updated){
        return create(updated);
    }

    @PostMapping
    public ResponseEntity<PropertyDTO> create(@RequestBody PropertyDTO newInstance){
        return ResponseEntity.ok(mapper.toDTO(service.create(mapper.toModel(newInstance))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            service.deleteById(id);
            return ResponseEntity.ok("deleted");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("There was some error");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PropertyDTO> getById(@PathVariable  Long id){
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @GetMapping
    public ResponseEntity<Set<PropertyDTO>> getAll(){
        return ResponseEntity.ok(mapper.toDTOList(service.getAll()));
    }


}
