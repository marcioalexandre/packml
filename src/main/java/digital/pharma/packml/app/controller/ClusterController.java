package digital.pharma.packml.app.controller;

import digital.pharma.packml.app.dto.ClusterDTO;
import digital.pharma.packml.app.mapper.ClusterDTOMapper;
import digital.pharma.packml.domain.service.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("cluster/v1")
public class ClusterController {

    @Autowired
    ClusterService service;
    ClusterDTOMapper mapper = ClusterDTOMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ClusterDTO created){
        try {
            @PutMapping
            public ResponseEntity<ClusterDTO> update(@RequestBody ClusterDTO updated) throws Exception {
                return ResponseEntity.ok(mapper.toDTO(service.update(mapper.toModel(updated))));
            }

            return ResponseEntity.ok(mapper.toDTO(service.create(mapper.toModel(created))));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("root")
    public ResponseEntity<ClusterDTO> getByRoot(){
        return ResponseEntity.ok(mapper.toDTO(service.getRoot()));
    }
}
