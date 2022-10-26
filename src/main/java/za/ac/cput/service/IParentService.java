package za.ac.cput.service;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Service - IParentService.java
 * October 2022
 */

import za.ac.cput.domain.parent;

import java.util.List;
import java.util.Optional;

public interface IParentService extends IService<parent, String>{
    public List<parent> getAll();

}
