package repository;

import model.Toyota;

import java.util.List;

public interface ToyotaRepository {
    List<Toyota> findAll();
    Toyota findById(int id);
    void save(Toyota toyota);
    void delete(Toyota toyota);
}
