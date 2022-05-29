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
@RequestMapping("/garage")
public class GarageController {
    
    @Autowired
    GarageService garageService;

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String listAllGarages(Model html) {
        List<Garage> garagesList = garageService.getAllGarage();
        html.addAttribute("garagesList", garagesList);
        html.addAttribute("noDataGarage", new Garage());
        List<Car> carsList = carService.getAllCars();
        html.addAttribute("carsList", carsList);
        return "garage";
    }


    @PostMapping("/save")
    public String saveGarage(@ModelAttribute("noDataGarage") Garage garage) {
        garageService.saveGarage(garage);
        return "redirect:/garage/";
    }


    @GetMapping("/delete/{id}")
    public String deleteGarage(@PathVariable("id") int id) {
        garageService.deleteGarageById(id);
        return "redirect:/garage/";
    }
    

    @PostMapping("/update/{id}")
    public String updateGarage(@PathVariable("id") int id, @ModelAttribute("noDataGarage") Garage garage) {
        garageService.saveGarage(garage);
        return "redirect:/garage/";
    }
}
