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
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;
import za.ac.cput.service.ILoginService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j

public class LoginController {
    private final ILoginService service;

    @Autowired
    public LoginController(ILoginService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Login> safe(@Valid @RequestBody Login login) {
        log.info("Save request:{}", login);
        Login newLogin;
        try {
            newLogin = LoginFactory.createLogin(login.getLoginID(), login.getEmail(), login.getPassword());
        } catch (IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Login save = service.save(newLogin);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Login> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Login login = this.service.read(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(login);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request:{}", id);
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("readAllLogin")
    public ResponseEntity<java.util.List<Login>> readAll() {
        List<Login> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }
}
