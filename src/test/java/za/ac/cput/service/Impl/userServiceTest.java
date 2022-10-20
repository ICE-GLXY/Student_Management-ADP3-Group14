package za.ac.cput.service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user;
import za.ac.cput.factory.userFactory;
import za.ac.cput.repository.IUserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class userServiceTest {

    @Autowired
    userService userService;
    private static user user1, user2;
    private IUserRepository repository;

    @Test
    @Order(1)
    void save()
    {
        user1 = userFactory.createUser("devtesters@gmail.com", "Password", "password", 5, "student");
        user createUser1 = userService.save(user1);
        assertNotNull(createUser1);
        System.out.println(createUser1);

        user2 = userFactory.createUser("desters@gmail.com", "Pasord", "parmation", 7, "student");
        user createUser2 = userService.save(user2);
        assertNotNull(createUser2);
        System.out.println(createUser2);

        System.out.println("users have been added");
    }

    @Test
    @Order(2)
    void read()
    {
        System.out.println(userService.read("desters@gmail.com"));
    }

    @Test
    @Order(3)
    void delete()
    {
        userService.delete(userService.findByEmailAddress("desters@gmail.com"));
        assertNotNull(user2);
        System.out.println("user deleted successfully");
    }

    @Test
    @Order(4)
    void getAll()
    {
        System.out.println(userService.getAll());
    }

}