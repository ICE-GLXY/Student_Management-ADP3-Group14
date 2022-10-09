package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Parent;
import za.ac.cput.service.IParentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j

public class ParentController {
    private final IParentService repository;

    @Autowired
    public ParentController(IParentService repository) {
        this.repository = repository;
    }

    @PostMapping("save_parent")
    public ResponseEntity<Parent> save(@Valid @RequestBody Parent saveParent){
        log.info("Save request: {}",saveParent);

        try{
            Parent newParent = repository.save(saveParent);
            return ResponseEntity.ok(newParent);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readParent/{parentID}")
    public ResponseEntity<Optional<Parent>> read(@PathVariable String parentID){
        log.info("Read request: {}",parentID);

        try {
            Optional<Parent> readParent = repository.read(parentID);
            return ResponseEntity.ok(readParent);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteParent/{parentId}")
    public ResponseEntity<Parent> delete(@PathVariable String parentId){
        log.info("Delete request: {}",parentId);

        this.repository.delete(parentId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllParents")
    public ResponseEntity<List<Parent>> readAll(){
        List<Parent> list = this.repository.findAll();
        return ResponseEntity.ok(list);
    }
}
