package repository;

import model.Model;
import model.Toyota;

import java.util.List;

public interface ToyotaRepository {
    List<Toyota> findAll();
    Toyota findById(int id);
    void save(Toyota toyota);
    void delete(Toyota toyota);
    List<Model> findAllModels();
    Model findModelById(int modelId);
}
