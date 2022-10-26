package za.ac.cput.service.Impl;

/* SubjectServiceImpl.java
Author: Chante Lewis:216118395
Date: 30 September 2022
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.ISubjectRepository;
import za.ac.cput.service.ISubjectService;


import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements ISubjectService {
    private final ISubjectRepository repository;

    @Autowired
    public SubjectServiceImpl(ISubjectRepository repository) {
        this.repository = repository;
    }

    //Save operation
    @Override
    public Subject save(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public Optional<Subject> read(String s) {
        return Optional.empty();
    }


    //Read one operation
    @Override
    public Optional<Subject> read(int subjectID) {
        return this.repository.findById(String.valueOf(subjectID));
    }

    @Override
    //Delete operation
    public void delete(Subject subject) {
        this.repository.delete(subject);
    }

    //Delete by studentId
    @Override
    public void deleteByID(int subjectID) {
        Optional<Subject> subject = read(subjectID);
        if (subject.isPresent()) delete(subject.get());
    }

    @Override
    //Read all operation
    public List<Subject> findAll() {
        return this.repository.findAll();
    }

    public List<Subject> findSubjectBySubjectName(String subjectName) {
        return repository.findSubjectBySubjectName(subjectName);
    }
}
