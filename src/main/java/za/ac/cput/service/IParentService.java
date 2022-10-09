package za.ac.cput.service;

import za.ac.cput.domain.Parent;

import java.util.List;

public interface IParentService extends IService<Parent, String> {
    List<Parent> findAll();

    void delete(String id);
}
