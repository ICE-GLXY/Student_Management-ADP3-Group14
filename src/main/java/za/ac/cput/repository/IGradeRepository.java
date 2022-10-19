package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.grade;

@Repository
public interface IGradeRepository extends JpaRepository<grade, String> {


}
