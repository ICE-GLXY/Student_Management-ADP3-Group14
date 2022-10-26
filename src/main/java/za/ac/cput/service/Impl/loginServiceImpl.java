/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.login;
import za.ac.cput.repository.ILoginRepository;
import za.ac.cput.service.ILoginService;

import java.util.List;
import java.util.Optional;

@Service
public class loginServiceImpl implements ILoginService {

    private final ILoginRepository repository;

    @Autowired
    public loginServiceImpl(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public login save(login login) {
        return this.repository.save(login);
    }

    @Override
    public Optional<login> read(String loginNumber) {
        return this.repository.findById(loginNumber);
    }

    //update?
    @Override
    public login update(login login) {
        return this.repository.save(login);
    }

    @Override
    public void delete(login login) {this.repository.delete(login);}

    @Override
    public List<login> findAll() {
        return this.repository.findAll();
    }

    public login deleteById(String loginNumber){
        Optional <login> login = read(loginNumber);
        if(login.isPresent())delete(login.get());
        return null;
    }


}
