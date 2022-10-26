package za.ac.cput.service;

import za.ac.cput.domain.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    List<Teacher> findAll();

    Teacher save(Teacher teacher);

    Optional<Teacher> read(String id);

    void delete(String id);

    void delete(Teacher teacher);
}
