package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.grade;
import za.ac.cput.repository.IGradeRepository;
import za.ac.cput.service.IGradeService;


import java.util.*;

@Service
public class gradeServiceImpl implements IGradeService {

    private final IGradeRepository repository;

    @Autowired
    public gradeServiceImpl(IGradeRepository repository) {
        this.repository = repository;
    }


    @Override
    public grade save(grade saveGrade) {
        return this.repository.save(saveGrade);
    }

    @Override
    public Optional<grade> read(String gradeID) {
        return this.repository.findById(gradeID);
    }

    @Override
    public void delete(grade grade) {
        this.repository.delete(grade);
    }

    @Override
    public List<grade> readAll() {
        return this.repository.findAll();
    }
}
