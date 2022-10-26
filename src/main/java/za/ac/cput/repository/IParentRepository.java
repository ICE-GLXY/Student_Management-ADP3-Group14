package za.ac.cput.repository;
/*
 * Abdul Aleem Chilwan - 220108447
 * ADP3 - Final Capstone
 * Repository - IParentRepository.java
 * October 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.parent;

@Repository
public interface IParentRepository extends JpaRepository<parent, String> {
}
