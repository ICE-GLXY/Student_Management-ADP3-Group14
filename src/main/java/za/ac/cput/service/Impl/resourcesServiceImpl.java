package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.resources;
import za.ac.cput.repository.IResourcesRepository;
import za.ac.cput.service.IResourcesService;

import java.util.List;
import java.util.Optional;

public class resourcesServiceImpl implements IResourcesService {

    private final IResourcesRepository repository;

    @Autowired
    public resourcesServiceImpl(IResourcesRepository repository) {
        this.repository = repository;
    }


    @Override
    public resources save(resources saveResources) {
        return this.repository.save(saveResources);
    }

    @Override
    public Optional<resources> read(String resourcesID) {
        return this.repository.findById(resourcesID);
    }

    @Override
    public void delete(resources resources) {
        this.repository.delete(resources);
    }

    @Override
    public List<resources> readAll() {
        return this.repository.findAll();
    }
}
