package za.ac.cput.repository;
/*
 * Mogamad Taariq Phillips - 220166153
 * IUserRepository.java
 * Creation of IUserRepository
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<user, String> {
    public user findByEmailAddress(String emailAddress);
}
