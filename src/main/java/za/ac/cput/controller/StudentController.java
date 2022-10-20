package za.ac.cput.controller;

/* StudentController.java
Author: Chante Lewis:216118395
15/08/2022
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Student;
import za.ac.cput.service.IStudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student_management/student/")
@Slf4j
public class StudentController {

    private IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    //Save student
    @PostMapping("save_Student")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        log.info("Save request: {}", student);
        Student save = iStudentService.save(student);
        return ResponseEntity.ok(save);

    }

    //Read student by id
    @GetMapping("read/{id}")
    public ResponseEntity<Optional<Student>> read(@PathVariable int studentID) {
        log.info("Read request: {}", studentID);
        Optional<Student> student = this.iStudentService.read(studentID);
        student.orElseThrow();
        return ResponseEntity.ok(student);

    }

    //Delete student by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int studentID) {
        log.info("Delete request: {}", studentID);
        this.iStudentService.deleteByID(studentID);
        return ResponseEntity.noContent().build();
    }

    //Find all students
    @GetMapping("all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> student = this.iStudentService.findAll();
        return ResponseEntity.ok(student);
    }

    @GetMapping("readByStudentsByName/{student_name}")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String studentName) {
        log.info("readByStudentsByName request: {}", studentName);

        try {
            List<Student> readByStudentsByName = iStudentService.findStudentsByStudentName(studentName);
            return ResponseEntity.ok(readByStudentsByName);

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
