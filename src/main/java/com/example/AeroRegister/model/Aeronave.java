package com.example.AeroRegister.model;

/**
 * Representa un registro de aeronave del archivo oficial de matrículas vigentes.
 * Los ocho atributos se conservan como texto para no perder valores como
 * "SIN INFORMACION" en la fecha de inscripción.
 */
public class Aeronave {

    private final String matricula;
    private final String tipoMatricula;
    private final String estadoMatricula;
    private final String fechaInscripcion;
    private final String fabricante;
    private final String modelo;
    private final String numeroSerie;
    private final String titularidadExplotacion;

    public Aeronave(String matricula, String tipoMatricula, String estadoMatricula,
                    String fechaInscripcion, String fabricante, String modelo,
                    String numeroSerie, String titularidadExplotacion) {
        this.matricula = matricula;
        this.tipoMatricula = tipoMatricula;
        this.estadoMatricula = estadoMatricula;
        this.fechaInscripcion = fechaInscripcion;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.titularidadExplotacion = titularidadExplotacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipoMatricula() {
        return tipoMatricula;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getTitularidadExplotacion() {
        return titularidadExplotacion;
    }
}
