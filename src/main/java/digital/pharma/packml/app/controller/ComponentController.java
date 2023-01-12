package digital.pharma.packml.app.controller;

import digital.pharma.packml.app.dto.ComponentDTO;
import digital.pharma.packml.app.mapper.ComponentDTOMapper;
import digital.pharma.packml.domain.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("component/v1")
public class ComponentController {

    @Autowired
    ComponentService service;
    ComponentDTOMapper mapper = ComponentDTOMapper.INSTANCE;

    @PutMapping
    public ResponseEntity<ComponentDTO> update(@RequestBody ComponentDTO updated){
        return create(updated);
    }

    @PostMapping
    public ResponseEntity<ComponentDTO> create(@RequestBody ComponentDTO newInstance){
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
    public ResponseEntity<ComponentDTO> getById(@PathVariable  Long id){
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @GetMapping
    public ResponseEntity<Set<ComponentDTO>> getAll(){
        return ResponseEntity.ok(mapper.toDTOList(service.getAll()));
    }
}
