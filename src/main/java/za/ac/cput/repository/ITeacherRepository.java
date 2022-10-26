package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Teacher;
@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, String> {

}
