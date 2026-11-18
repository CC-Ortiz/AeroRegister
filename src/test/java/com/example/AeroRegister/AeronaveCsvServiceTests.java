package com.example.AeroRegister;

import com.example.AeroRegister.services.AeronaveCsvService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class AeronaveCsvServiceTests {

    @Autowired
    private AeronaveCsvService aeronaveCsvService;

    @Test
    void debeCargarLos1891RegistrosDelCsv() {
        assertEquals(1891, aeronaveCsvService.obtenerTotal());
        assertEquals(1891, aeronaveCsvService.obtenerTodas().size());
    }

    @Test
    void debeLeerLasOchoColumnasYConservarFechaSinInformacion() {
        var aeronave = aeronaveCsvService.obtenerTodas().get(0);

        assertEquals("CCAWA", aeronave.getMatricula());
        assertEquals("DEFINITIVA", aeronave.getTipoMatricula());
        assertEquals("VIGENTE", aeronave.getEstadoMatricula());
        assertEquals("SIN INFORMACION", aeronave.getFechaInscripcion());
        assertEquals("AIRBUS", aeronave.getFabricante());
        assertEquals("A-320-232", aeronave.getModelo());
        assertEquals("7595", aeronave.getNumeroSerie());
        assertFalse(aeronave.getTitularidadExplotacion().isBlank());
    }
}
