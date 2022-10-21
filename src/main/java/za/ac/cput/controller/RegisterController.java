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
import za.ac.cput.domain.Register;
import za.ac.cput.factory.RegisterFactory;
import za.ac.cput.service.IRegisterService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j
public class RegisterController {

    private final IRegisterService service;
    @Autowired
    public RegisterController(IRegisterService service){this.service = service;}

    @PostMapping("save")
    public ResponseEntity<Register> safe(@Valid @RequestBody Register register)
    {
        log.info("Save request:{}", register);
        Register newRegister;
        try
        {
            newRegister = RegisterFactory.createRegister(register.getRegisterNumber(),register.getEmail(),register.getPassword(),register.getSchool(),register.getParent(),register.getStudent());
        }
        catch(IllegalArgumentException iae)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Register save = service.save(newRegister);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{registerNumber}")
    public ResponseEntity<Register> read(@PathVariable String registerNumber)
    {
        log.info("Read request:{}", registerNumber);
        Register register = this.service.read(registerNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(register);
    }

    @DeleteMapping("delete/{registerNumber}")
    public ResponseEntity<Void> delete(@PathVariable String registerNumber)
    {
        log.info("Read request:{}", registerNumber);
        this.service.delete(registerNumber);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("readAllRegister")
    public ResponseEntity<List<Register>> readAll(){
        List<Register> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }

}