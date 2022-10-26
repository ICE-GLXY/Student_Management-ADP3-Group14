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
import za.ac.cput.service.IRegisterService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("School_Management-ADP3-Group14/register")
@Slf4j
public class registerController {

    private final IRegisterService repository;

    @Autowired
    registerController(IRegisterService repository) {
        this.repository = repository;
    }


    @PostMapping("save_register")
    public ResponseEntity<register> save(@Valid @RequestBody register saveRegister) {
        log.info("Save request:{}", saveRegister);
        //za.ac.cput.domain.register newRegister;
        try {
            register newRegister = repository.save(saveRegister);
            return ResponseEntity.ok(newRegister);
            //newRegister = registerFactory.createRegister(register.getRegisterNumber(),register.getEmail(),register.getPassword(),register.getSchool(),register.getParent(),register.getStudent());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        //za.ac.cput.domain.register save = repository.save(newRegister);
        //return ResponseEntity.ok(save);
    }

    @PutMapping("update_Register")
    public ResponseEntity<register> update(@Valid @RequestBody register updateRegister) {
        try {
            updateRegister = this.repository.update(updateRegister);
            return ResponseEntity.ok(updateRegister);

        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }


    @GetMapping("read_register/{registerNumber}")
    public ResponseEntity<Optional<register>> read(@PathVariable String registerNumber) {
        log.info("Read request:{}", registerNumber);
        try {
            Optional<register> readRegister = repository.read(registerNumber);
            return ResponseEntity.ok(readRegister);
//            register register = this.repository.read(registerNumber).orElseThrow(
//                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
//            );
            //return ResponseEntity.ok(register);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }

    @DeleteMapping("delete_register/{registerNumber}")
    public ResponseEntity<register> delete(@PathVariable String registerNumber) {
        log.info("Read request:{}", registerNumber);
        this.repository.delete(registerNumber);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("readAllRegisters")
    public ResponseEntity<List<register>> readAll() {
        List<register> list = this.repository.findAll();
        return ResponseEntity.ok(list);
    }

}
