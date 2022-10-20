package za.ac.cput.service;

import za.ac.cput.domain.grade;

import java.util.List;
import java.util.Optional;

public interface IGradeService {
    grade save(grade saveGrade);

    Optional<grade> read(String gradeID);

    void delete(grade grade);

    List<grade> readAll();
}
