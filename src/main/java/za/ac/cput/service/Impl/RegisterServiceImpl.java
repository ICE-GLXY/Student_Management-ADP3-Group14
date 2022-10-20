package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Register;
import za.ac.cput.repository.IRegisterRepository;
import za.ac.cput.service.IRegisterService;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements IRegisterService {

    private final IRegisterRepository repository;

    @Autowired
    public RegisterServiceImpl(IRegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Register> read(String registerNumber) {
        return this.repository.findById(registerNumber);
    }

    @Override
    public Register save(Register register) {
        return this.repository.save(register);
    }


    @Override
    public void delete(Register register) {

    }

    @Override
    public void delete(String registerNumber) {
        this.repository.deleteById(registerNumber);
    }


    @Override
    public List<Register> findAll() {
        return this.repository.findAll();
    }

}
