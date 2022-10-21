package za.ac.cput.service;

import za.ac.cput.domain.Login;
import za.ac.cput.domain.Parent;

import java.util.List;
import java.util.Optional;

public interface IParentService {
    Optional<Parent> read(String id);

    Parent save(Parent parent);

    void delete(Parent parent);

    void delete(String Id);

    List<Parent> findAll();
}
