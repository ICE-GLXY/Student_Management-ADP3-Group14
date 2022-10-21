package za.ac.cput.service;

import za.ac.cput.domain.Parent;
import za.ac.cput.domain.School;

import java.util.List;
import java.util.Optional;

public interface ISchoolService {
    Optional<School> read(String id);

    School save(School school);

    void delete(School school);

    void delete(String Id);

    List<School> findAll();
}
