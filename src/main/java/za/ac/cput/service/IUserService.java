package za.ac.cput.service;

import za.ac.cput.domain.user;

import java.util.List;

public interface IUserService extends IService<user, String>{
    public List<user> getAll();
}
