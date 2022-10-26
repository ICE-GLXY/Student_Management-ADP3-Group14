package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.parent;
import za.ac.cput.factory.parentFactory;

import javax.lang.model.element.Name;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class parentControllerTest {
    @LocalServerPort
    private int portNo;
    private String baseURL;
    private parent parent1;
    @Autowired
    private parentController parentController;
    @Autowired
    private TestRestTemplate restTemplate;
    
    @BeforeEach
    void setUp(){
        assertNotNull(parentController);
        parent1 = parentFactory.createParent("A3114","Lisa","Lisa@gmail.com","021943204",
                "82 Losta Road","Lisa123","LisaOri");
        this.baseURL = "http://localhost:" + this.portNo + "/Student_Management-ADP3-Group14/parent/";
    }
    @Test
    @Order(1)
    void save(){
        String url = baseURL + "save_parent";
        System.out.println(url);
        
        ResponseEntity<parent> responseEntity = this.restTemplate.postForEntity(url, this.parent1, parent.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
        System.out.println("Parent saved");
    }
    
    @Test
    @Order(2)
    void read(){
        String url = baseURL + "readParent/" + parent1.getParentCode();
        System.out.println(url);
        ResponseEntity<parent> responseEntity= this.restTemplate.getForEntity(url, parent.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody())
        );
    }
    
    @Test
    @Order(3)
    void delete(){
        String url = baseURL + "deleteParent/" + parent1.getParentCode();
        System.out.println(url);
        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("A3114", parent1.getParentCode()),
                () -> assertNotNull(parent1.getParentCode())
        );
    }
    
    @Test
    @Order(4)
    void getAll(){
        String url = baseURL + "readAllParents";
        System.out.println(url);
        ResponseEntity<parent[]> responseEntity = this.restTemplate.getForEntity(url, parent[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0)
        );
    }
}

