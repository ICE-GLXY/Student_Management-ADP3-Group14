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
import za.ac.cput.domain.login;
import za.ac.cput.factory.loginFactory;
import za.ac.cput.service.ILoginService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/EmployeeAddress/")
@Slf4j

public class loginController {
    private final ILoginService service;

    @Autowired
    public loginController(ILoginService service) {
        this.service = service;
    }

    @PostMapping("save_login")
    public ResponseEntity<login> safe(@Valid @RequestBody login login) {
        log.info("Save request:{}", login);
        za.ac.cput.domain.login newLogin;
        try {
            newLogin = loginFactory.createLogin(login.getloginNumber(), login.getEmail(), login.getPassword());
        } catch (IllegalArgumentException iae) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        za.ac.cput.domain.login save = service.save(newLogin);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read_login/{loginNumber}")
    public ResponseEntity<login> read(@PathVariable String loginNumber) {
        log.info("Read request:{}", loginNumber);
        login login = this.service.read(loginNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(login);
    }

    @DeleteMapping("delete_login/{loginNumber}")
    public ResponseEntity<Void> delete(@PathVariable login loginNumber) {
        log.info("Read request:{}", loginNumber);
        this.service.delete(loginNumber);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("readAllLogins")
    public ResponseEntity<java.util.List<login>> readAll() {
        List<login> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }
}
