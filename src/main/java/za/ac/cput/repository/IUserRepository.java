package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user;

public interface IUserRepository extends JpaRepository<user, String> {
    public user findByEmailAddress(String emailAddress);
}
