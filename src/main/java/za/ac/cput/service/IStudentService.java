package za.ac.cput.service;

import za.ac.cput.domain.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentService extends IService<Student,String> {

    List<Student> findAll();

    //Read one operation
    Optional<Student> read(int studentID);

    void deleteByID(int studentID);

    List<Student> findStudentsByStudentName(String studentName);
}


