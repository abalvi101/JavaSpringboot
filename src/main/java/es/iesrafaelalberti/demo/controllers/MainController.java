package es.iesrafaelalberti.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping({"/"})
    public String welcome(@RequestParam(name = "nombre", required = false, defaultValue = "Antonio") String nombre,
                          @RequestParam(name = "apellidos", required = false, defaultValue = "Pérez") String apellidos,
                          @RequestParam(name = "dni", required = false, defaultValue = "77666555") String dni,
                          @RequestParam(name = "ciudad", required = false, defaultValue = "Cádiz") String ciudad,
                          Model model) {

        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidos", apellidos);
        model.addAttribute("dni", dni);
        model.addAttribute("ciudad", ciudad);

        return "form";
    }

    @GetMapping({"/dni"})
    public String devuelveNIF(@RequestParam(name = "nombre", required = true) String nombre,
                              @RequestParam(name = "apellidos", required = true) String apellidos,
                              @RequestParam(name = "dni", required = true) String dni,
                              @RequestParam(name = "ciudad", required = true) String ciudad,
                              Model model) {

        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidos", apellidos);
        model.addAttribute("nif", dni + DniController.calcularLetra(dni));
        model.addAttribute("ciudad", ciudad);

        return "nif";
    }
}
