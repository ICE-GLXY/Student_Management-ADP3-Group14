/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.service;

import za.ac.cput.domain.login;

import java.util.List;

public interface ILoginService extends IService<login, String>{
    List<login> findAll();
    login deleteById(String loginNumber);
}
