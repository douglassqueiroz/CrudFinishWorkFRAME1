package br.edu.ifms.relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.relacionamentos.model.Car;
import br.edu.ifms.relacionamentos.model.Garage;
import br.edu.ifms.relacionamentos.service.CarService;
import br.edu.ifms.relacionamentos.service.GarageService;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    GarageService garageService;

    @GetMapping("/")
    public String listAllCars(Model html) {
        List<Car> carsList = carService.getAllCars();
        html.addAttribute("carsList", carsList);
        html.addAttribute("noDataCar", new Car());
        List<Garage> garageList = garageService.getAllGarage();
        html.addAttribute("garageList", garageList);
        return "car";
    }


    @PostMapping("/save")
    public String saveCar(@ModelAttribute("noDataCar") Car car) {
        carService.saveCar(car);
        return "redirect:/car/";
    }


    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id) {
        carService.deleteCarById(id);
        return "redirect:/car/";
    }


    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable("id") int id, @ModelAttribute("noDataCar") Car car) {
        carService.saveCar(car);
        return "redirect:/car/";
    }
}
