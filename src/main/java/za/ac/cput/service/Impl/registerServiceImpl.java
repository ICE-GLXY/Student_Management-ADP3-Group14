/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.register;
import za.ac.cput.repository.IRegisterRepository;
import za.ac.cput.service.IRegisterService;

import java.util.List;
import java.util.Optional;

@Service
public class registerServiceImpl implements IRegisterService {

    private final IRegisterRepository repository;

    @Autowired
    public registerServiceImpl(IRegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<register> read(String registerNumber) {
        return this.repository.findById(registerNumber);
    }

    @Override
    public register save(register register) {
        return this.repository.save(register);
    }


    @Override
    public void delete(register register) {

    }

    @Override
    public void delete(String registerNumber) {
        this.repository.deleteById(registerNumber);
    }


    @Override
    public List<register> findAll() {
        return this.repository.findAll();
    }

}
