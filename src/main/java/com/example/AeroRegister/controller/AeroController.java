package com.example.AeroRegister.controller;

import com.example.AeroRegister.services.AeronaveCsvService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AeroController {

    private final AeronaveCsvService aeronaveCsvService;

    public AeroController(AeronaveCsvService aeronaveCsvService) {
        this.aeronaveCsvService = aeronaveCsvService;
    }

    @GetMapping("/aeronaves")
    public String listarAeronaves(Model model) {

        model.addAttribute(
            "aeronaves",
            aeronaveCsvService.obtenerTodas()
        );

        model.addAttribute(
            "totalAeronaves",
            aeronaveCsvService.obtenerTotal()
        );

        return "aeronaves";
    }
}

