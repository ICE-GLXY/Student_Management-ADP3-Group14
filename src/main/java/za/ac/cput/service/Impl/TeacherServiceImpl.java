package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Teacher;
import za.ac.cput.repository.ITeacherRepository;
import za.ac.cput.service.ITeacherService;

import java.util.List;
import java.util.Optional;


@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(ITeacherRepository repository){

        this.repository = repository;
    }

    @Override
    public List<Teacher> findAll() {

        return this.repository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher){

        return this.repository.save(teacher);
    }

    @Override
    public Optional<Teacher> read(String id){

        return this.repository.findById(id);
    }

    @Override
    public void delete(String id) {

        this.repository.deleteById(id);
    }

    @Override
    public void delete(Teacher teacher){

        this.repository.delete(teacher);
    }
}

