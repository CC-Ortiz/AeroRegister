package com.example.AeroRegister.services;

import com.example.AeroRegister.model.Aeronave;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Carga una única vez en memoria las aeronaves incluidas en
 * src/main/resources/data/aeronaves.csv. No utiliza base de datos.
 */
@Service
public class AeronaveCsvService {

    private static final String CSV_PATH = "data/aeronaves.csv";

    private static final String COL_MATRICULA = "Número de matrícula";
    private static final String COL_TIPO = "Tipo de matrícula";
    private static final String COL_ESTADO = "Estado de la matrícula";
    private static final String COL_FECHA = "Fecha de inscripción";
    private static final String COL_FABRICANTE = "Marca o fabricante";
    private static final String COL_MODELO = "Modelo";
    private static final String COL_SERIE = "Número de serie";
    private static final String COL_TITULARIDAD = "Titularidad y explotación";

    private List<Aeronave> aeronaves = List.of();

    @PostConstruct
    public void cargarAeronaves() {
        ClassPathResource resource = new ClassPathResource(CSV_PATH);

        try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
             CSVParser parser = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setIgnoreEmptyLines(true)
                    .setTrim(true)
                    .get()
                    .parse(reader)) {

            this.aeronaves = parser.getRecords().stream()
                    .map(this::convertirRegistro)
                    .toList();

            if (this.aeronaves.isEmpty()) {
                throw new IllegalStateException("El archivo CSV no contiene registros: " + CSV_PATH);
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "No fue posible leer el archivo CSV ubicado en classpath:" + CSV_PATH, e);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(
                    "El archivo CSV no contiene los encabezados esperados o tiene una estructura inválida.", e);
        }
    }

    private Aeronave convertirRegistro(CSVRecord registro) {
        return new Aeronave(
                registro.get(COL_MATRICULA),
                registro.get(COL_TIPO),
                registro.get(COL_ESTADO),
                registro.get(COL_FECHA),
                registro.get(COL_FABRICANTE),
                registro.get(COL_MODELO),
                registro.get(COL_SERIE),
                registro.get(COL_TITULARIDAD)
        );
    }

    /**
     * Devuelve los registros cargados en memoria.
     */
    public List<Aeronave> obtenerTodas() {
        return aeronaves;
    }

    /**
     * Devuelve la cantidad de registros cargados.
     */
    public int obtenerTotal() {
        return aeronaves.size();
    }
}
