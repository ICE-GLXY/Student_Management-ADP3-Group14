package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Mark;
import za.ac.cput.repository.IMarkRepository;
import za.ac.cput.service.IMarkService;


import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements IMarkService {
    private final IMarkRepository repository;

    @Autowired
    public MarkServiceImpl(IMarkRepository repository){

        this.repository = repository;
    }

    @Override
    public List<Mark> findAll() {

        return this.repository.findAll();
    }

    @Override
    public Mark save(Mark mark){

        return this.repository.save(mark);
    }

    @Override
    public Optional<Mark> read(String id){

        return this.repository.findById(id);
    }

    @Override
    public void delete(String id) {

        this.repository.deleteById(id);
    }

    @Override
    public void delete(Mark mark){

        this.repository.delete(mark);
    }
}
