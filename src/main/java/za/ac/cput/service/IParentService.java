package za.ac.cput.service;

import za.ac.cput.domain.parent;

import java.util.List;
import java.util.Optional;

public interface IParentService extends IService<parent, String>{
    public List<parent> getAll();

}
