package za.ac.cput.repository;

/* IStudentRepository.java
Author: Chante Lewis: 216118395
Date: 30 September 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;
import java.util.List;


@Repository
public interface IStudentRepository extends JpaRepository<Student,String> {
    List<Student> findStudentsByStudentName(String studentName);

    //  Optional<Student> findById(int studentID);
}

