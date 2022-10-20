package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.user;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class userFactoryTest {

    @Test
    @Order(1)
    void createUser()
    {
        user user = userFactory.createUser("2220163153@mycput.ac.za","pass2201","pass2201",6,"Student");
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    @Order(2)
    void createUserNoPass()
    {
        user user = userFactory.createUser("2220163153@mycput.ac.za","","pass2201",6,"Student");
        System.out.println(user.toString());
        assertNotNull(user);
    }
    @Test
    @Order(3)
    void createUserNoPassConf()
    {
        user user = userFactory.createUser("2220163153@mycput.ac.za","pass2201","",6,"Student");
        System.out.println(user.toString());
        assertNotNull(user);
    }
    @Test
    @Order(4)
    void createUserNoStud()
    {
        user user = userFactory.createUser("2220163153@mycput.ac.za","pass2201","pass2201",6,"");
        System.out.println(user.toString());
        assertNotNull(user);
    }
}