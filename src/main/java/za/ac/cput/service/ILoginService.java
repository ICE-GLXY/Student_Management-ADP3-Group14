package za.ac.cput.service;

import za.ac.cput.domain.Login;

import java.util.List;
import java.util.Optional;

public interface ILoginService {
    Optional<Login> read(String id);

    Login save(Login login);

    void delete(Login login);

    void delete(String Id);

    List<Login> findAll();
}
