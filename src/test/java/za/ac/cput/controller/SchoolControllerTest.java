//package za.ac.cput.controller;
//
//
///*
//Abdul Aleem Chilwan (220108447)
//ADP3 - Final Capstone Project 2022
//Date: Aug 2022
//School Management
// */
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.domain.*;
//import za.ac.cput.factory.*;
//import java.util.Arrays;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//
//public class SchoolControllerTest {
//
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private ParentController controller;
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private School school;
//    private String baseUrl;
//
//    @BeforeEach
//    void setUp() {
//        assertNotNull(controller);
//        this.school = SchoolFactory.build("761A","High School");
//        this.baseUrl = "http://localhost:" + this.port + "/school_management/school/";
//    }
//
//    @Test
//    @Order(1)
//    void save() {
//        String url = baseUrl + "save";
//        System.out.println(url);
//        ResponseEntity<School> response = this.restTemplate
//                .postForEntity(url, this.school, School.class);
//        System.out.println(response);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
//    }
//
//    @Order(2)
//    @Test
//    void read() {
//        String url = baseUrl + "readSchool/" + school.getSchoolId();
//        ResponseEntity<School> responseEntity = this.restTemplate
//                .getForEntity(url, School.class);
//
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
//                () -> assertNotNull(responseEntity.getBody())
//        );
//    }
//
//    @Order(5)
//    @Test
//    void delete() {
//        String url = baseUrl + "deleteSchool/" + school.getSchoolId();
//        String id = "761A";
//        ResponseEntity<Void> response = restTemplate.exchange(url + id,
//                HttpMethod.DELETE,
//                null,
//                Void.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()),
//                () -> assertNull(response.getBody())
//        );
//
//    }
//
//    @Order(3)
//    @Test
//    void readAll() {
//        String url = baseUrl + "getAllSchools";
//        System.out.println(url);
//
//        ResponseEntity<School[]> responseEntity = this.restTemplate
//                .getForEntity(url, School[].class);
//
//        System.out.println(Arrays.asList(responseEntity.getBody()));
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
//                () -> assertTrue(responseEntity.getBody().length == 0)
//        );
//
//    }
//
//    @Order(4)
//    @Test
//    void getSchoolById() {
//        String email = "devtesters@gmail.com";
//        String url = baseUrl + "getSchoolById" + school.getSchoolId();
//        ResponseEntity<School> response = restTemplate.getForEntity(url, School.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
//
//    }
//}