package za.ac.cput.service;

import za.ac.cput.domain.School;

import java.util.List;

public interface ISchoolService extends IService<School, String> {
    List<School> findAll();

    void delete(String id);
}
