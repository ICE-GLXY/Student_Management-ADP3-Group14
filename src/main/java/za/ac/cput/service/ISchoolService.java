package za.ac.cput.service;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Service - ISchoolService.java
 * October 2022
 */

import za.ac.cput.domain.school;

import java.util.List;

public interface ISchoolService extends IService<school, String>{
    public List<school> getAll();
    
}
