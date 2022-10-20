package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user;
import za.ac.cput.factory.userFactory;

import javax.lang.model.element.Name;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class userControllerTest
{
    @LocalServerPort
    private int portNo;
    private String baseURL;
    private user user1;
    @Autowired
    private userController userController;
    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp()
    {
        assertNotNull(userController);
        user1 = userFactory.createUser("devtesters@gmail.com", "Password", "password", 5, "student");
        this.baseURL = "http://localhost:" + this.portNo + "/Student_Management-ADP3-Group14/user/";
    }
    @Test
    @Order(1)
    void save()
    {
        String url = baseURL + "save_user";
        System.out.println(url);

        ResponseEntity<user> responseEntity = this.restTemplate.postForEntity(url, this.user1, user.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
        System.out.println("User saved");
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseURL + "readUser/" + user1.getEmailAddress();
        System.out.println(url);
        ResponseEntity<user> responseEntity = this.restTemplate.getForEntity(url, user.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(3)
    void delete()
    {
        String url = baseURL + "deleteUser/" + user1.getEmailAddress();
        System.out.println(url);

        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("devtesters@gmail.com", user1.getEmailAddress()),
                () -> assertNotNull(user1.getEmailAddress()));
    }

    @Test
    @Order(4)
    void getAll()
    {
        String url = baseURL + "readAllUsers";
        System.out.println(url);
        ResponseEntity<user[]> responseEntity = this.restTemplate.getForEntity(url, user[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0));
    }
}