package za.ac.cput.repository;

/* ISubjectRepository.java
Author: Chante Lewis: 216118395
Date: 30 September 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Subject;
import java.util.List;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject,String> {
    List<Subject> findSubjectBySubjectName(String subjectName);
}