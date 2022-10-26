package za.ac.cput.controller;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Controller - ParentContoller.java
 * October 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.parent;
import za.ac.cput.domain.school;
import za.ac.cput.service.IParentService;
import za.ac.cput.service.ISchoolService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Student_Management-ADP3-Group14/parent")
@Slf4j
public class parentController {
    private final IParentService repository;
    
    @Autowired
    parentController(IParentService repository){this.repository = repository;}
    
    @PostMapping("save_parent")
    public ResponseEntity<parent> save(@Valid @RequestBody parent saveParent){
        log.info("Save request: {}",saveParent);
        
        try{
            parent newParent = repository.save(saveParent);
            return ResponseEntity.ok(newParent);
        }
        catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    
    @PutMapping("update_parent")
    public ResponseEntity<parent> update(@Valid @RequestBody parent updateParent) {
        try {
            parent updatedParent = this.repository.update(updateParent);
            return ResponseEntity.ok(updatedParent);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
    
        @GetMapping("readParent/{parentCode}")
        public ResponseEntity<Optional<parent>> read(@PathVariable String parentCode){
            log.info("Read request: {}",parentCode);
        
            try{
                Optional<parent> readParent = repository.read(parentCode);
                return ResponseEntity.ok(readParent);
            }
            catch (IllegalArgumentException e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
    
    @DeleteMapping("deleteParent/{parent}")
    public ResponseEntity<parent> delete(@PathVariable parent parent){
        log.info("Delete request: {}",parent);
        
        this.repository.delete(parent);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("readAllParents")
    public ResponseEntity<List<parent>> getAll(){
        List<parent> list = this.repository.getAll();
        return ResponseEntity.ok(list);
    }
}