package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Mark;

@Repository
public interface IMarkRepository extends JpaRepository<Mark, String> {
}
