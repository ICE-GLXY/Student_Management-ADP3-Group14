package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.parent;

@Repository
public interface IParentRepository extends JpaRepository<parent, String> {
}
