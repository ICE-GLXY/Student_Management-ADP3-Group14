package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Login;
import za.ac.cput.domain.Register;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFactoryTest {
    @Test
    void createRegister() {
        Register register = RegisterFactory.createRegister("01","@gmail",
                "gmail","PPHS","Yes","no");
        assertNotNull(register);
        System.out.println(register);
        System.out.println("Registered success");
    }

    @Test
    public void buildWithSuccess(){
        Register register = RegisterFactory.createRegister("01","@gmail",
                "gmail","PPHS","Yes","no");
        assertNotNull(register);
        System.out.println(register);
        System.out.println("Registered success");
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> RegisterFactory.createRegister(null,"@gmail",
                        "gmail","PPHS","Yes","no"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("RegisterID"));
        System.out.println("there was a error");
    }
}