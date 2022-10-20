package za.ac.cput.service;

import za.ac.cput.domain.Login;
import za.ac.cput.domain.Register;

import java.util.List;
import java.util.Optional;

public interface IRegisterService {
    Optional<Register> read(String id);

    Register save(Register register);

    void delete(Register register);

    void delete(String id);

    List<Register> findAll();
}
