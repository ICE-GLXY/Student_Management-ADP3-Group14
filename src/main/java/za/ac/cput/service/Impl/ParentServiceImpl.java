package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Parent;
import za.ac.cput.repository.IParentRepository;
import za.ac.cput.service.IParentService;

import java.util.List;
import java.util.Optional;

public class ParentServiceImpl implements IParentService {

    private final IParentRepository repository;

    @Autowired
    public ParentServiceImpl(IParentRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Parent> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Parent save(Parent parent){
        return this.repository.save(parent);
    }

    @Override
    public Optional<Parent> read(String id){
        return Optional.of(this.repository.getById(id));
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(Parent parent){
        this.repository.delete(parent);
    }
}
