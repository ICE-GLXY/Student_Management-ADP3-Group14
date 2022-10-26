package za.ac.cput.factory;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * SchoolFactorytTest
 * October 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.school;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class schoolFactoryTest {

    @Test
    @Order(1)
    void createSchool(){
        school school = schoolFactory.createSchool("A402","Rylands High");
        System.out.println(school.toString());
        assertNotNull(school);
    }
    @Test
    @Order(2)
    void createSchoolNoName(){
        school school = schoolFactory.createSchool("B302","");
        System.out.println(school.toString());
        assertNotNull(school);
    }

    @Test
    @Order(3)
    void createSchoolNoId(){
        school school = schoolFactory.createSchool("","Zeekovlei Primary");
        System.out.println(school.toString());
        assertNotNull(school);
    }
}
