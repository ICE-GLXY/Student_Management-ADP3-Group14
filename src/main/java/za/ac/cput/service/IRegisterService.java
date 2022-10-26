/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.service;


import za.ac.cput.domain.register;

import java.util.List;
import java.util.Optional;

public interface IRegisterService {
    Optional<register> read(String id);

    register save(register register);

    void delete(register register);

    void delete(String id);

    List<register> findAll();
}
