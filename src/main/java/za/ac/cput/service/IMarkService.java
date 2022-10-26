package za.ac.cput.service;

import za.ac.cput.domain.Mark;

import java.util.List;
import java.util.Optional;

public interface IMarkService {
    List<Mark> findAll();

    Mark save(Mark mark);

    Optional<Mark> read(String id);

    void delete(String id);

    void delete(Mark mark);
}
