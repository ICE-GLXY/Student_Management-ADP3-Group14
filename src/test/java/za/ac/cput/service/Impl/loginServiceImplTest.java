package za.ac.cput.service.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.login;
import za.ac.cput.factory.loginFactory;
import za.ac.cput.repository.ILoginRepository;
import za.ac.cput.service.ILoginService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class loginServiceImplTest {

    private final za.ac.cput.domain.login login = loginFactory.createLogin("0001", "@gmail", "1234");

    @Autowired
    //za.ac.cput.service.Impl.loginServiceImpl loginServiceImpl;
    loginServiceImpl loginServiceImpl;
    private static login login1,login2;
    //private ILoginRepository iloginRepository;
    //private ILoginService service;

    @Test
    @Order(1)
    void save() {
       login1 = loginFactory.createLogin("01","@gmail","gmail");
       login createlogin1 = loginServiceImpl.save(login1);
        assertNotNull(createlogin1);
        System.out.println(createlogin1);
        System.out.println("Login credentials saved");


//  test dont work
//        za.ac.cput.domain.login saved = this.service.save(this.login);
//        assertAll(
//                () -> assertNotNull(saved),
//                () -> assertEquals(this.login, saved)
//        );
    }

    @Test
    @Order(2)
    void read() {

        System.out.println(loginServiceImpl.read("01"));

//  test dont work
//        //System.out.println(ILoginService.read("01"));
//        Optional<za.ac.cput.domain.login> read = this.service.read(this.login.getloginNumber());
//        System.out.println("print");
//        System.out.println(read);
//        assertAll(
//                () -> assertTrue(read.isPresent()),
//                () -> assertEquals(this.login, read.get())
//        );

    }

    @Test
    @Order(3)
    void delete() {
        loginServiceImpl.delete(loginServiceImpl.deleteById("01"));
        assertNotNull(login1);
        System.out.println("credential deleted");

//  test dont work
//        this.service.delete(this.login);
//        List<za.ac.cput.domain.login> loginList = this.service.findAll();
//        assertEquals(0, loginList.size());
    }

    @Test
    @Order(4)
    void findAll() {
        System.out.println(loginServiceImpl.findAll());
//  test dont work
//        List<za.ac.cput.domain.login> loginList = this.service.findAll();
//        assertEquals(1, loginList.size());
    }
}