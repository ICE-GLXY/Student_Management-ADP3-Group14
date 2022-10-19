//package za.ac.cput.controller;
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
//public class ParentControllerTest {
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private ParentController controller;
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private Parent parent;
//    private String baseUrl;
//
//    public static Parent parent = ParentFactory.build("A3920","Abdul","Chilwan",
//            "Abdul@gmail.com", "0214930291", "40 Larva Road Monte Vista",
//            "Abdul123", "AbdulChilwan");
//
//    @BeforeEach
//    void setUp() {
//        assertNotNull(controller);
//        this.parent = ParentFactory.build("A3920","Abdul","Chilwan",
//                "Abdul@gmail.com", "0214930291", "40 Larva Road Monte Vista",
//                "Abdul123", "AbdulChilwan");
//        this.baseUrl = "http://localhost:" + this.port + "/school_management/parent/";
//    }
//
//    @Test
//    @Order(1)
//    void save() {
//        String url = baseUrl + "save";
//        System.out.println(url);
//        ResponseEntity<Parent> response = this.restTemplate
//                .postForEntity(url, this.parent, Parent.class);
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
//        String url = baseURL + "readParent/" + parent.getParentId();
//        ResponseEntity<Parent> responseEntity = this.restTemplate
//                .getForEntity(url, Parent.class);
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
//        String url = baseURL + "deleteEmployee/" + parent.getParentId();
//        String id = "761A";
//        ResponseEntity<Void> response = testRestTemplate.exchange(url + id,
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
//        String url = baseURL + "getAllParents";
//        System.out.println(url);
//
//        ResponseEntity<Parent[]> responseEntity = this.testRestTemplate
//                .getForEntity(url, Parent[].class);
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
//    void getParentById() {
//        String email = "devtesters@gmail.com";
//        String url = baseURL + "getEmployeeByEmail" + email;
//        ResponseEntity<Parent> response = testRestTemplate.getForEntity(url, Parent.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
//
//    }
//}