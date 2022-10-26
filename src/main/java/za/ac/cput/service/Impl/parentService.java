package za.ac.cput.service.Impl;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Service Impl- ParentService.java
 * October 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.parent;
import za.ac.cput.domain.school;
import za.ac.cput.repository.IParentRepository;
import za.ac.cput.service.IParentService;

import java.util.List;
import java.util.Optional;

@Service
public class parentService implements IParentService {
    private final IParentRepository repository;
    
    @Autowired parentService(IParentRepository repository){this.repository = repository;}
    
    @Override
    public parent save(parent parent){return this.repository.save(parent);}
    
    @Override
    public Optional<parent> read(String id){return this.repository.findById(id);}
    
    @Override
    public parent update(parent parent){return this.repository.save(parent);}
    
    @Override
    public void delete(parent parent){this.repository.delete(parent);}
    
    @Override
    public List<parent> getAll(){
        return this.repository.findAll();
    }
    
    
    
}
