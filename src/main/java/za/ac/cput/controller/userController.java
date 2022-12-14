package za.ac.cput.controller;
/*
 * Mogamad Taariq Phillips - 220166153
 * userController.java
 * Creation of controller for user
 *
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user;
import za.ac.cput.service.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Student_Management-ADP3-Group14/user")
@Slf4j
public class userController {

    private final IUserService repository;

    @Autowired
    userController(IUserService repository) {
        this.repository = repository;
    }

    @PostMapping("save_user")
    public ResponseEntity<user> save(@Valid @RequestBody user saveUser){
        log.info("Save request: {}",saveUser);

        try{
            user newUser = repository.save(saveUser);
            return ResponseEntity.ok(newUser);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //should update exist ??
    @PutMapping("update_user")
    public ResponseEntity<user> update(@Valid @RequestBody user updateUser){
        try{
            user updatedUser = this.repository.update(updateUser);
            return ResponseEntity.ok(updatedUser);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    //Read does not work
    @GetMapping("readUser/{userEmailAddress}")
    public ResponseEntity<Optional<user>> read(@PathVariable String emailAddress){
        log.info("Read request: {}",emailAddress);

        try {
            Optional<user> readUser = repository.read(emailAddress);
            return ResponseEntity.ok(readUser);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteUser/{user}")
    public ResponseEntity<user> delete(@PathVariable user user){
        log.info("Delete request: {}",user);

        this.repository.delete(user);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllUsers")
    public ResponseEntity<List<user>> getAll(){
        List<user> list = this.repository.getAll();
        return ResponseEntity.ok(list);
    }

}
