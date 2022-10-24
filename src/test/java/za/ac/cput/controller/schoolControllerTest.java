package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.school;
import za.ac.cput.factory.schoolFactory;

import javax.lang.model.element.Name;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class schoolControllerTest {
        @LocalServerPort
        private int portNo;
        private String baseURL;
        private school school1;
        @Autowired
        private schoolController schoolController;
        @Autowired
        private TestRestTemplate restTemplate;
        
        @BeforeEach
        void setUp(){
            assertNotNull(schoolController);
            school1 = schoolFactory.createSchool("B141","Westlake High");
            this.baseURL = "http://localhost:" + this.portNo + "/Student_Management-ADP3-Group14/school/";
        }
        @Test
        @Order(1)
        void save(){
            String url = baseURL + "save_school";
            System.out.println(url);
            
            ResponseEntity<school> responseEntity = this.restTemplate.postForEntity(url, this.school1, school.class);
            System.out.println(responseEntity);
            assertAll(
                    () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                    () -> assertNotNull(responseEntity.getBody()));
            System.out.println("School saved");
        }
        
        @Test
        @Order(2)
        void read(){
            String url = baseURL + "readSchool/" + school1.getSchoolId();
            System.out.println(url);
            ResponseEntity<school> responseEntity= this.restTemplate.getForEntity(url, school.class);
            System.out.println(responseEntity);
            assertAll(
                    () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                    () -> assertNotNull(responseEntity.getBody())
            );
        }
        
        @Test
        @Order(3)
        void delete(){
            String url = baseURL + "deleteSchool/" + school1.getSchoolId();
            System.out.println(url);
            this.restTemplate.delete(url);
            assertAll(
                    () -> assertSame("B141", school1.getSchoolId()),
                    () -> assertNotNull(school1.getSchoolId())
            );
        }
        
        @Test
        @Order(4)
        void getAll(){
            String url = baseURL + "readAllSchools";
            System.out.println(url);
            ResponseEntity<school[]> responseEntity = this.restTemplate.getForEntity(url, school[].class);
            System.out.println(Arrays.asList(responseEntity.getBody()));
            assertAll(
                    () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                    () -> assertTrue(responseEntity.getBody().length == 0)
                    );
        }
    }

