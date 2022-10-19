package za.ac.cput.factory;

/*
   Factory Test for the School entity
   Author: Abdul Aleem Chilwan
   StudNo: 220108447
   Date: Aug 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import static org.junit.jupiter.api.Assertions.*;

public class SchoolFactoryTest {
    public static School school = SchoolFactory.build("S40291","Wynberg High");

    @Test
    public void buildWithSucccess() {
        System.out.println(school);
        assertNotNull(school);
    }

    @Test
    public void buildWithErrror() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                SchoolFactory.build(null, "Plumstead High"));

        String exceptionMessage = exception.getMessage();
        assertSame("schoolId is required", exceptionMessage);

    }

}
