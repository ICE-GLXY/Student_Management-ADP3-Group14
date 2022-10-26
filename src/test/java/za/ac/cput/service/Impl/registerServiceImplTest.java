package za.ac.cput.service.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.registerFactory;
import za.ac.cput.service.IRegisterService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class registerServiceImplTest {
    private final za.ac.cput.domain.register register = registerFactory.createRegister("01", "@gmail",
            "gmail", "PPHS", "Yes", "no");

    @Autowired
    private IRegisterService service;

    @Test
    @Order(1)
    void save() {
        za.ac.cput.domain.register saved = this.service.save(this.register);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.register, saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<za.ac.cput.domain.register> read = this.service.read(this.register.getRegisterNumber());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.register, read.get())
        );

    }

    @Test
    @Order(3)
    void delete() {
        this.service.delete(this.register);
        List<za.ac.cput.domain.register> registerList = this.service.findAll();
        assertEquals(0, registerList.size());
    }

    @Test
    @Order(4)
    void findAll() {
        List<za.ac.cput.domain.register> registerList = this.service.findAll();
        assertEquals(1, registerList.size());
    }
}