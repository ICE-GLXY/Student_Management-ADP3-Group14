package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Parent;
import za.ac.cput.domain.School;
import za.ac.cput.service.IParentService;
import za.ac.cput.service.ISchoolService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
//@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j
public class SchoolController {
    private final ISchoolService repository;

    @Autowired
    public SchoolController(ISchoolService repository) {
        this.repository = repository;
    }

    @PostMapping("save_school")
    public ResponseEntity<School> save(@Valid @RequestBody School saveSchool){
        log.info("Save request: {}",saveSchool);

        try{
            School newSchool = repository.save(saveSchool);
            return ResponseEntity.ok(newSchool);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readSchool/{schoolId}")
    public ResponseEntity<Optional<School>> read(@PathVariable String schoolID){
        log.info("Read request: {}",schoolID);

        try {
            Optional<School> readSchool = repository.read(schoolID);
            return ResponseEntity.ok(readSchool);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}

