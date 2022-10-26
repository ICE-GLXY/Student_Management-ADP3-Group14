package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.login;
import za.ac.cput.factory.loginFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class loginControllerTest {

    //Test for security here

    @LocalServerPort
    private int port;


    @Autowired private LoginController controller;
    @Autowired private TestRestTemplate restTemplate;

    private za.ac.cput.domain.login login;
    private String baseURL;


    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.login = loginFactory.createLogin("01", "@gmail.com", "12345678");
        this.baseURL = "http://localhost:" + this.port + "/Student_Management-ADP3-Group14/user/";
    }

    @Test
    @Order(1)
    void safe(){
        String url = baseURL + "saveLogin";
        System.out.println(url);
        ResponseEntity<za.ac.cput.domain.login> responseEntity = this.restTemplate.postForEntity(url, this.login, za.ac.cput.domain.login.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "readLogin/" + login.getloginNumber();
        System.out.println(url);
        ResponseEntity<za.ac.cput.domain.login> responseEntity = this.restTemplate.getForEntity(url, login.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseURL + "readLogin/" + login.getloginNumber();
        System.out.println(url);

        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("01", login.getloginNumber()),
                () -> assertNotNull(login.getloginNumber()));
    }

    @Test
    void readAll() {
        String url = baseURL + "readAllLogin credentials";
        System.out.println(url);
        ResponseEntity<login[]> responseEntity = this.restTemplate.getForEntity(url, login[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0));
    }
}