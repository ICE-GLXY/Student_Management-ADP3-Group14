package za.ac.cput.service;

import za.ac.cput.domain.school;

import java.util.List;

public interface ISchoolService extends IService<school, String>{
    public List<school> getAll();
    
}
