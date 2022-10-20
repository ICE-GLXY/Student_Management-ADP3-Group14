package za.ac.cput.controller;

/*
Titilayo Akinjole - 220283982
ADP3
School Management
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.grade;
import za.ac.cput.service.IGradeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("School_Management-ADP3-Group14/grade/")
@Slf4j
public class gradeController {
    private final IGradeService repository;
    @Autowired
    gradeController(IGradeService repository) {
        this.repository = repository;
    }

    @PostMapping("save_grade")
    public ResponseEntity<grade> save(@Valid @RequestBody grade saveGrade){
        log.info("Save request: {}",saveGrade);

        try{
            grade newGrade = repository.save(saveGrade);
            return ResponseEntity.ok(newGrade);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readGrade/{gradeID}")
    public ResponseEntity<Optional<grade>> read(@PathVariable String gradeID){
        log.info("Read request: {}",gradeID);

        try {
            Optional<grade> readGrade = repository.read(gradeID);
            return ResponseEntity.ok(readGrade);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteGrade/{grade}")
    public ResponseEntity<grade> delete(@PathVariable grade grade){
        log.info("Delete request: {}",grade);

        this.repository.delete(grade);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllGrade")
    public ResponseEntity<List<grade>> readAll(){
        List<grade> list = this.repository.readAll();
        return ResponseEntity.ok(list);
    }
}
