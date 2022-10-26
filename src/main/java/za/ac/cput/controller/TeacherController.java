package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import za.ac.cput.domain.Teacher;
import za.ac.cput.factory.TeacherFactory;
import za.ac.cput.service.ITeacherService;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("School_Management-ADP3-Group14/teacher/")
@Slf4j

public class TeacherController {
    private final ITeacherService iTeacherService;

    @Autowired
    public TeacherController(ITeacherService iTeacherService)
    {
        this.iTeacherService = iTeacherService;
    }

    @PostMapping("save_Teacher")
    public ResponseEntity<Teacher> save(@Valid @RequestBody Teacher teacher){
        log.info("save request:{}",teacher);
        Teacher valTeacher;
        try {
            valTeacher = TeacherFactory.createTeacher(teacher.getTeacherID(), teacher.getUsername(), teacher.getPassword(), teacher.getEmail());
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Teacher save = iTeacherService.save(valTeacher);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read_Teacher/{id}")
    public ResponseEntity<Teacher> read(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        Teacher teacher = this.iTeacherService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("delete_Teacher/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Read request:{}", id);
        this.iTeacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll_Teacher")
    public ResponseEntity<List<Teacher>> findAll()
    {
        List <Teacher> teacher = this.iTeacherService.findAll();
        return ResponseEntity.ok(teacher);
    }
}