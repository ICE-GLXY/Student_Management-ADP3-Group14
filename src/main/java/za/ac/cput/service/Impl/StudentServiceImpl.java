package za.ac.cput.service.Impl;

/* StudentServiceImpl.java
Author: Chante Lewis:216118395
Date: 30 September 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.service.IStudentService;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository repository;

    @Autowired
    public StudentServiceImpl(IStudentRepository repository){
        this.repository = repository;
    }

    //Save operation
    @Override
    public Student save(Student student){return this.repository.save(student);}

    @Override
    public Optional<Student> read(String s) {
        return Optional.empty();
    }

    //Read one operation
    @Override
    public Optional<Student> read(int studentID) {
        return this.repository.findById(String.valueOf(studentID));
    }

    @Override
    //Delete operation
    public void delete(Student student) {this.repository.delete(student);}

    //Delete by studentId
    @Override
    public void deleteByID(int studentID) {
        Optional<Student> student = read(studentID);
        if(student.isPresent()) delete (student.get());
    }

    //Read all operation
    public List<Student> findAll() {return this.repository.findAll();}

    public List<Student> findStudentsByStudentName(String studentName) {
        return repository.findStudentsByStudentName(studentName);
    }

}
