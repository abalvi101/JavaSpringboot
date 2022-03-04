package es.iesrafaelalberti.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DniController {

    public static char calcularLetra(String dni) {
        String caracteres="TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = Integer.parseInt(dni)%23;
        return caracteres.charAt(resto);
    }
}
