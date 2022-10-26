/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.register;
import za.ac.cput.factory.registerFactory;
import za.ac.cput.service.IRegisterService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j
public class registerController {

    private final IRegisterService service;
    @Autowired
    public registerController(IRegisterService service){this.service = service;}

    @PostMapping("save_register")
    public ResponseEntity<register> safe(@Valid @RequestBody register register)
    {
        log.info("Save request:{}", register);
        za.ac.cput.domain.register newRegister;
        try
        {
            newRegister = registerFactory.createRegister(register.getRegisterNumber(),register.getEmail(),register.getPassword(),register.getSchool(),register.getParent(),register.getStudent());
        }
        catch(IllegalArgumentException iae)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        za.ac.cput.domain.register save = service.save(newRegister);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read_register/{registerNumber}")
    public ResponseEntity<register> read(@PathVariable String registerNumber)
    {
        log.info("Read request:{}", registerNumber);
        register register = this.service.read(registerNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(register);
    }

    @DeleteMapping("delete_register/{registerNumber}")
    public ResponseEntity<Void> delete(@PathVariable String registerNumber)
    {
        log.info("Read request:{}", registerNumber);
        this.service.delete(registerNumber);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("readAllRegisters")
    public ResponseEntity<List<register>> readAll(){
        List<register> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }

}
