package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    // Página inicial
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    // Criar novo carro
    @PostMapping("/cars")
    public String createCar(@ModelAttribute CarDTO car, Model model) {
        carService.save(car);

        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);

        return "dashboard";
    }

    // Listar todos os carros
    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);

        return "dashboard";
    }

}
