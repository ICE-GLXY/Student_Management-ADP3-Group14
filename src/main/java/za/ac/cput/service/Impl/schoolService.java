package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.school;
import za.ac.cput.repository.ISchoolRepository;
import za.ac.cput.service.ISchoolService;

import java.util.List;
import java.util.Optional;

@Service
public class schoolService implements ISchoolService {
    private final ISchoolRepository repository;
    
    @Autowired
    public schoolService(ISchoolRepository repository){this.repository = repository;}
    
    @Override
    public school save(school school){return this.repository.save(school);}
    
    @Override
    public Optional<school> read(String id){return this.repository.findById(id);}
    
    @Override
    public school update(school school){return this.repository.save(school);}
    
    @Override
    public void delete(school school){this.repository.delete(school);}
    
    @Override
    public List<school> getAll(){
        return this.repository.findAll();
    }
    
    public school findByNumber(String id){return this.repository.findByNumber(id);}
    
    
}
