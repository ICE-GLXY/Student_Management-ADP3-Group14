/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.login;

@Repository
public interface ILoginRepository extends JpaRepository<login, String> {
public login findByloginNumber(String loginNumber);
}
