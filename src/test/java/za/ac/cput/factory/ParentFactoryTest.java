package za.ac.cput.factory;
/*
Factory Test for the Parent entity
Author: Abdul Aleem Chilwan
StudNo: 220108447
Date: Aug 2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

public class ParentFactoryTest {
    public static Parent parent = ParentFactory.build("A3920","Abdul","Chilwan",
            "Abdul@gmail.com", "0214930291", "40 Larva Road Monte Vista",
            "Abdul123", "AbdulChilwan");

    @Test
    public void buildWithSucccess() {
        System.out.println(parent);
        assertNotNull(parent);
    }

    @Test
    public void buildWithErrror() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ParentFactory.build(null, "liam", "Chilwan",
                        "Abdul@gmail.com", "0214930291", "40 Larva Road Monte Vista",
                        "Abdul123", "AbdulChilwan"));

        String exceptionMessage = exception.getMessage();
        assertSame("parentId is required", exceptionMessage);

    }

}
