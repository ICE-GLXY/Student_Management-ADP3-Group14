package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Login;
import za.ac.cput.domain.Parent;
import za.ac.cput.domain.School;
import za.ac.cput.repository.ISchoolRepository;
import za.ac.cput.service.ISchoolService;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements ISchoolService {

    private final ISchoolRepository repository;

    @Autowired
    public SchoolServiceImpl(ISchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<School> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public School save(School school) {
        return this.repository.save(school);
    }

    @Override
    public void delete(School school) {

    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }


    @Override
    public List<School> findAll() {
        return this.repository.findAll();
    }


}
