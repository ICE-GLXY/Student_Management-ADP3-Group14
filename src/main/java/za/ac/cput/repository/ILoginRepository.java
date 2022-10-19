package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String> {

}
