package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Garage;
import br.edu.ifms.relacionamentos.repository.GarageRepository;

@Service
public class GarageService {
    
    @Autowired
    GarageRepository garageRepository;


    public List<Garage> getAllGarage() {
        return garageRepository.findAll();
    }

    
    public Garage getGarageById(int id) {
        return garageRepository.getById(id);
    }


    public void saveGarage(Garage garage) {
        garageRepository.save(garage);
    }


    public void deleteGarageById(int id) {
        garageRepository.deleteById(id);
    }
}
