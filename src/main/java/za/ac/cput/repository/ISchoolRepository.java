package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.school;

@Repository
public interface ISchoolRepository extends JpaRepository<school, String> {
}
