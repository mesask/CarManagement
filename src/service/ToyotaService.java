package service;

import model.Model;
import model.Toyota;

import java.util.List;

public interface ToyotaService {
    List<Toyota> getAll();
    Toyota getAllById(int id);
    void insert(Toyota toyota);
    void update(Toyota toyota);
    void delete(int id);
    List<Model> getAllModels();
    Model getModelById(int id);
}
