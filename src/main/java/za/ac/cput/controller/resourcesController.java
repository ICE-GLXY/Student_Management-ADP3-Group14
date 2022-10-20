package za.ac.cput.controller;
/*
Titilayo Akinjole - 220283982
ADP3
School Management
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.resources;
import za.ac.cput.service.IResourcesService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("School_Management-ADP3-Group14/grade/")
@Slf4j

public class resourcesController {
    private final IResourcesService repository;
    @Autowired
    resourcesController(IResourcesService repository) {
        this.repository = repository;
    }

    @PostMapping("save_resources")
    public ResponseEntity<resources> save(@Valid @RequestBody resources saveResources){
        log.info("Save request: {}",saveResources);

        try{
            resources newResources = repository.save(saveResources);
            return ResponseEntity.ok(newResources);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readResources/{ResourcesID}")
    public ResponseEntity<Optional<resources>> read(@PathVariable String resourcesID){
        log.info("Read request: {}",resourcesID);

        try {
            Optional<resources> readResources = repository.read(resourcesID);
            return ResponseEntity.ok(readResources);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteResources/{resource}")
    public ResponseEntity<resources> delete(@PathVariable resources resources){
        log.info("Delete request: {}",resources);

        this.repository.delete(resources);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllResources")
    public ResponseEntity<List<resources>> readAll(){
        List<resources> list = this.repository.readAll();
        return ResponseEntity.ok(list);
    }
}

