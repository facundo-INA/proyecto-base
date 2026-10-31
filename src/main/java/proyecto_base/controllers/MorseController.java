package proyecto_base.controllers;

import proyecto_base.services.TraductorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    private final TraductorService traductorService;

    // Inyección de dependencias por constructor
    public MorseController(TraductorService traductorService) {
        this.traductorService = traductorService;
    }

    @GetMapping("/traducir")
    public String traducir(@RequestParam String codigo) {
        return traductorService.traducirMorse(codigo);
    }
}