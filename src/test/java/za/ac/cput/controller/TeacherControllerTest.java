package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Teacher;
import za.ac.cput.factory.TeacherFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TeacherControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private TeacherController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Teacher teacher;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.teacher = TeacherFactory
                .createTeacher("01","Teacher1","123","teacher1@yahoo.com");
        this.baseUrl = "http://localhost:"+ this.port+"/Student_Management-ADP3-Group14/teacher/";

    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save_Teacher";
        System.out.println(url);

        ResponseEntity<Teacher> responseEntity = this.restTemplate.postForEntity(url, this.teacher, Teacher.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
        System.out.println("Teacher saved");
    }


    @Test
    @Order(2)
    void read()
        {
            String url = baseUrl + "read_Teacher/" + teacher.getEmail();
            System.out.println(url);
            ResponseEntity<Teacher> responseEntity = this.restTemplate.getForEntity(url, Teacher.class);
            System.out.println(responseEntity);
            assertAll(
                    () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                    () -> assertNotNull(responseEntity.getBody()));
        }

    @Test
    @Order(3)
    void delete() {

            String url = baseUrl + "delete_Teacher/" + teacher.getUsername();
            System.out.println(url);

            this.restTemplate.delete(url);
            assertAll(
                    () -> assertSame("teacher2", teacher.getUsername()),
                    () -> assertNotNull(teacher.getUsername()));
    }


    @Test
    @Order(4)
    void findAll() {

            String url = baseUrl + "findAll_Teacher";
            System.out.println(url);
            ResponseEntity<Teacher[]> responseEntity = this.restTemplate.getForEntity(url, Teacher[].class);
            System.out.println(Arrays.asList(responseEntity.getBody()));
            assertAll(
                    () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                    () -> assertTrue(responseEntity.getBody().length == 0));
        }
    }




