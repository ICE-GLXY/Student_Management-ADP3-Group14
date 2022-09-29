package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.IUserService;

import java.util.List;
import java.util.Optional;


@Service
public class userService implements IUserService {
    private final IUserRepository repository;

    @Autowired
    public userService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public user save(user user) {
        return this.repository.save(user);
    }

    @Override
    public Optional<user> read(String emailAddress) {
        return this.repository.findById(emailAddress);
    }

    @Override
    public void delete(user user) {
        this.repository.delete(user);
    }

    @Override
    public List<user> getAll() {
        return this.repository.findAll();

    }

    public user findByEmailAddress(String emailAddress){
        return this.repository.findByEmailAddress(emailAddress);
    }

}
