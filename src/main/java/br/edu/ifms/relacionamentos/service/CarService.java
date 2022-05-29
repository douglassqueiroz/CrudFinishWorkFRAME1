package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Car;
import br.edu.ifms.relacionamentos.repository.CarRepository;

@Service
public class CarService {
    
    @Autowired
    CarRepository carRepository;


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    public Car getCarById(int id) {
        return carRepository.getById(id);
    }


    public void saveCar(Car car) {
        carRepository.save(car);
    }


    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
}
// 