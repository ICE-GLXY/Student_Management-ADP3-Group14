package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Login;
import za.ac.cput.repository.ILoginRepository;
import za.ac.cput.service.ILoginService;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService {

    private final ILoginRepository repository;

    @Autowired
    public LoginServiceImpl(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Login> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public Login save(Login login) {
        return this.repository.save(login);
    }

    @Override
    public void delete(Login login) {

    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }


    @Override
    public List<Login> findAll() {
        return this.repository.findAll();
    }


}
