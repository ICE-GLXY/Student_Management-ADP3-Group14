package za.ac.cput.service;

import za.ac.cput.domain.resources;

import java.util.List;
import java.util.Optional;

public interface IResourcesService {
    resources save(resources saveResources);

    Optional<resources> read(String resourcesID);

    void delete(resources resources);

    List<resources> readAll();
}
