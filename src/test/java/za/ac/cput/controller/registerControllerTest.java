package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.login;
import za.ac.cput.domain.register;
import za.ac.cput.factory.registerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class registerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private registerController registerController;
    @Autowired private TestRestTemplate restTemplate;

    private za.ac.cput.domain.register register;
    private String baseURL;

    @BeforeEach
    void setUp() {
        assertNotNull(registerController);
        this.register = registerFactory.createRegister("01", "@gmail.com", "12345678","","","");
        this.baseURL = "http://localhost:" + this.port + "/Student_Management-ADP3-Group14/user/";
    }

    @Test
    @Order(1)
    void safe() {
        String url = baseURL + "saveRegister";
        System.out.println(url);
        ResponseEntity<register> responseEntity = this.restTemplate.postForEntity(url, this.register, register.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "readRegister/" + register.getRegisterNumber();
        System.out.println(url);
        ResponseEntity<register> responseEntity = this.restTemplate.getForEntity(url, register.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseURL + "readRegister/" + register.getRegisterNumber();
        System.out.println(url);

        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("01", register.getRegisterNumber()),
                () -> assertNotNull(register.getRegisterNumber()));
    }

    @Test
    void readAll() {
        String url = baseURL + "readAllRegister credentials";
        System.out.println(url);
        ResponseEntity<register[]> responseEntity = this.restTemplate.getForEntity(url, register[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0));
    }
}