package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.school;
import za.ac.cput.service.ISchoolService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Student_Management-ADP3-Group14/school")
@Slf4j

public class schoolController {
    private final ISchoolService repository;
    
    @Autowired
    schoolController(ISchoolService repository){this.repository = repository;}
    
    @PostMapping("save_school")
    public ResponseEntity<school> save(@Valid @RequestBody school saveSchool){
        log.info("Save request: {}",saveSchool);
        
        try{
            school newSchool = repository.save(saveSchool);
            return ResponseEntity.ok(newSchool);
        }
        catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
    }
}
@PutMapping("update_user")
    public ResponseEntity<school> update(@Valid @RequestBody school updateSchool){
        try{
            school updatedSchool = this.repository.update(updateSchool);
            return ResponseEntity.ok(updatedSchool);
        }
        catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
}

@GetMapping("readSchool/{schoolId}")
    public ResponseEntity<Optional<school>> read(@PathVariable String id){
        log.info("Read request: {}",id);
        
        try{
            Optional<school> readSchool = repository.read(id);
            return ResponseEntity.ok(readSchool);
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
}

@DeleteMapping("deleteSchool/{school}")
    public ResponseEntity<school> delete(@PathVariable school school){
        log.info("Delete request: {}",school);
        
        this.repository.delete(school);
        return ResponseEntity.noContent().build();
}

@GetMapping("readAllSchools")
    public ResponseEntity<List<school>> getAll(){
    List<school> list = this.repository.getAll();
    return ResponseEntity.ok(list);
}
}
