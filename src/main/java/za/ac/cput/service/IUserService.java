package za.ac.cput.service;
/*
 * Mogamad Taariq Phillips - 220166153
 * IUserService.java
 * Creation of IUserService
 *
 */
import za.ac.cput.domain.user;

import java.util.List;

public interface IUserService extends IService<user, String>{
    public List<user> getAll();
}
