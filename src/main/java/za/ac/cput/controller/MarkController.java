package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Mark;
import za.ac.cput.factory.MarkFactory;
import za.ac.cput.service.IMarkService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("School_Management-ADP3-Group14/mark/")
@Slf4j
public class MarkController {
    private final IMarkService iMarkService;

    @Autowired
    public MarkController(IMarkService iMarkService)
    {
        this.iMarkService = iMarkService;
    }
    @PostMapping("save_Mark")
    public ResponseEntity<Mark> save(@Valid @RequestBody Mark mark){
        log.info("save request:{}",mark);
        Mark valMark;
        try {
            valMark = MarkFactory.createMark(mark.getMarkID(), mark.getMarkDescription(), mark.getMarkStudentId(), mark.getMarkSubjectId(), mark.getMarkResult());
            Mark save = iMarkService.save(valMark);
            return ResponseEntity.ok(save);
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("read_Mark/{id}")
    public ResponseEntity<Mark> read(@PathVariable String id){
        log.info("Read request:{}",id);
        Mark mark = this.iMarkService.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(mark);
    }

    @DeleteMapping("delete_Mark/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.iMarkService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAll_Mark")
    public ResponseEntity<List<Mark>>findAll() {
        List<Mark> marks = this.iMarkService.findAll();
        return ResponseEntity.ok(marks);
    }

}