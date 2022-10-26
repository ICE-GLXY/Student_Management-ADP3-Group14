package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.parent;
import za.ac.cput.domain.school;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class parentFactoryTest {
    @Test
@Order(1)
void createParent(){
    parent parent = parentFactory.createParent("A3114","Lisa","Lisa@gmail.com","021943204",
            "82 Losta Road","Lisa123","LisaOri");
    System.out.println(parent.toString());
    assertNotNull(parent);
}
    @Test
    @Order(2)
    void createParentNoName(){
        parent parent = parentFactory.createParent("A431","","Lisa@gmail.com","021943204",
                "82 Losta Road","Lisa123","LisaOri");
        System.out.println(parent.toString());
        assertNotNull(parent);
    }
    
    @Test
    @Order(3)
    void createParentNoId(){
        parent parent = parentFactory.createParent("","Lisa","Lisa@gmail.com","021943204",
                "82 Losta Road","Lisa123","LisaOri");
        System.out.println(parent.toString());
        assertNotNull(parent);
    }
}
