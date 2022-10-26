package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Mark;
import za.ac.cput.factory.MarkFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MarkControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MarkController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Mark mark;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.mark = MarkFactory
                .createMark("75","Distinction","student123","ADP3@",75.6F);
        this.baseUrl = "http://localhost:"+ this.port+"/Student_Management-ADP3-Group14/mark/";

    }
    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save_Mark";
        System.out.println(url);

        ResponseEntity<Mark> responseEntity = this.restTemplate.postForEntity(url, this.mark, Mark.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
        System.out.println("Mark saved");
    }


    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read_Mark/" + mark.getMarkID();
        System.out.println(url);
        ResponseEntity<Mark> responseEntity = this.restTemplate.getForEntity(url, Mark.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }


    @Test
    @Order(3)
    void delete() {

        String url = baseUrl + "delete_Mark/" + mark.getMarkDescription();
        System.out.println(url);

        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("mark", mark.getMarkDescription()),
                () -> assertNotNull(mark.getMarkDescription()));
    }


    @Test
    @Order(4)
    void findAll() {

        String url = baseUrl + "findAll_Mark";
        System.out.println(url);
        ResponseEntity<Mark[]> responseEntity = this.restTemplate.getForEntity(url, Mark[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0));
    }
}

