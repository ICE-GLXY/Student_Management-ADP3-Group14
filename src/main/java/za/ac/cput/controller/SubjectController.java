package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Subject;
import za.ac.cput.service.ISubjectService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("student_management/subject/")
@Slf4j
public class SubjectController {

    private ISubjectService iSubjectService;

    @Autowired
    public SubjectController( ISubjectService iSubjectService) {
        this.iSubjectService = iSubjectService;
    }

    //Save student
    @PostMapping("save_Subject")
    public ResponseEntity<Subject> save(@Valid @RequestBody Subject subject) {
        log.info("Save request: {}", subject);
        Subject save = iSubjectService.save(subject);
        return ResponseEntity.ok(save);

    }

    //Read student by id
    @GetMapping("read/{id}")
    public ResponseEntity<Subject> read(@PathVariable int subjectID) {
        log.info("Read request: {}", subjectID);
        Subject subject = this.iSubjectService.read(String.valueOf(subjectID))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(subject);

    }

    //Delete student by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int subjectID) {
        log.info("Delete request: {}", subjectID);
        this.iSubjectService.deleteByID(subjectID);
        return ResponseEntity.noContent().build();
    }

    //Find all students
    @GetMapping("all")
    public ResponseEntity<List<Subject>> findAll() {
        List<Subject> subject = this.iSubjectService.findAll();
        return ResponseEntity.ok(subject);
    }

    @GetMapping("readBySubjectName/{subjectName}")
    public ResponseEntity<List<Subject>> getBySubjectName(@RequestParam String subjectName) {
        log.info("readBySubjectName request: {}", subjectName);

        try {
            List<Subject> readBySubjectName = iSubjectService.findSubjectBySubjectName(subjectName);
            return ResponseEntity.ok(readBySubjectName);

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}