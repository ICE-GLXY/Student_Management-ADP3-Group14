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
import za.ac.cput.service.ILoginService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("School_Management-ADP3-Group14/login")
@Slf4j

public class loginController {
    private final ILoginService repository;

    @Autowired
    loginController(ILoginService repository) {
        this.repository = repository;
    }

    @PostMapping("save_login")
    public ResponseEntity<login> save(@Valid @RequestBody login saveLogin) {
        log.info("Save request:{}", saveLogin);
        //za.ac.cput.domain.login newLogin;
        try {
            login newLogin = repository.save(saveLogin);
            return ResponseEntity.ok(newLogin);
            //return ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
            //newLogin = loginFactory.createLogin(login.getloginNumber(), login.getEmail(), login.getPassword());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("read_login/{loginNumber}")
    public ResponseEntity<login> read(@PathVariable String loginNumber) {
        log.info("Read request:{}", loginNumber);
        login login = this.repository.read(loginNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(login);
    }

    //update maybe
    @PutMapping("update_Login")
    public ResponseEntity<login> update(@Valid @RequestBody login updateLogin) {
        try {
            login updatedUser = this.repository.update(updateLogin);
            return ResponseEntity.ok(updateLogin);

        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("delete_login/{login}")
    public ResponseEntity<login> delete(@PathVariable login login) {
        log.info("Delete request:{}", login);
        this.repository.delete(login);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("readAllLogins")
    public ResponseEntity<List<login>> findAll() {
        List<login> list = this.repository.findAll();
        return ResponseEntity.ok(list);
    }
}
