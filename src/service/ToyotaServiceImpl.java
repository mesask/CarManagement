package service;

import model.Model;
import model.Toyota;
import repository.ToyotaRepository;
import repository.ToyotaRepositoryImpl;

import java.util.List;

public class ToyotaServiceImpl implements ToyotaService {
    // Call Repository
    private final ToyotaRepository toyotaRepository;

    public ToyotaServiceImpl() {
        this.toyotaRepository = new ToyotaRepositoryImpl();
    }
    @Override
    public List<Toyota> getAll() {
        return toyotaRepository.findAll();
    }

    @Override
    public Toyota getAllById(int id) {
        return toyotaRepository.findById(id);
    }

    @Override
    public void insert(Toyota toyota) {
        toyotaRepository.save(toyota);
    }

    @Override
    public void update(Toyota toyota) {
        toyotaRepository.save(toyota);
    }

    @Override
    public void delete(int id) {
        toyotaRepository.delete(toyotaRepository.findById(id));
    }

    @Override
    public List<Model> getAllModels() {
        return toyotaRepository.findAllModels();
    }

    @Override
    public Model getModelById(int id) {
        return toyotaRepository.findModelById(id);
    }
}
