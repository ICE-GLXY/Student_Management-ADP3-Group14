/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Login;

import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {

    @Test
    void createLogin() {
        Login login = LoginFactory.createLogin("01","@gmail","gmail");
        assertNotNull(login);
        System.out.println(login);
    }

    @Test
    public void buildWithSuccess(){
        Login login = LoginFactory.createLogin("02","2@gmail","2gmail");
        assertNotNull(login);
        System.out.println(login);
    }

    @Test
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,
        () -> LoginFactory.createLogin(null,"3@gmail.com","3@gmail"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("loginID"));
        //System.out.println("there was a error");
    }
}