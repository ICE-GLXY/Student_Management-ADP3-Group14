/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.register;

import static org.junit.jupiter.api.Assertions.*;

class registerFactoryTest {
    @Test
    void createRegister() {
        register register = registerFactory.createRegister("01","@gmail",
                "gmail","PPHS","Yes","no");
        assertNotNull(register);
        System.out.println(register);
        System.out.println("Registered success");
    }

    @Test
    public void buildWithSuccess(){
        register register = registerFactory.createRegister("01","@gmail",
                "gmail","PPHS","Yes","no");
        assertNotNull(register);
        System.out.println(register);
        System.out.println("Registered success");
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> registerFactory.createRegister(null,"@gmail",
                        "gmail","PPHS","Yes","no"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("RegisterID"));
        System.out.println("there was a error");
    }
}