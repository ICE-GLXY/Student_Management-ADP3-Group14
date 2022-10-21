package za.ac.cput.service;

import za.ac.cput.domain.Subject;
import java.util.List;
import java.util.Optional;

public interface ISubjectService extends IService<Subject,String>{

    List<Subject> findAll();

    //Read one operation
    Optional<Subject> read(int subjectID);

    void deleteByID(int subjectID);

    List<Subject> findSubjectBySubjectName(String subjectName);
}