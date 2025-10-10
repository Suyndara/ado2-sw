package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    // Formulário específico de carro
    @GetMapping("/car/form")
    public String exibirFormulario(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index"; // ou "formCar.html" se quiser separar as views
    }

    @PostMapping("/carros")
    public String salvarCarro(@Valid CarDTO carDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "index"; // volta para o formulário em caso de erro
        }

        System.out.println("Carro validado com sucesso: " + carDTO.getName() + ", " + carDTO.getColor());

        return "redirect:/sucesso";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }
}
