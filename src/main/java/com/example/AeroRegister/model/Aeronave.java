package com.example.AeroRegister.model;

import java.sql.Date;

public class Aeronave {
    private String matricula;
    private String tipo_matricula;
    private String estado_de_matricula;
    private Date fecha_de_registro;
    private String fabricante;
    private String modelo;
    private String numero_de_serie;
    private String titularidad;
    

    public Aeronave(String matricula, String tipo_matricula ,String fabricante, String modelo, String numero_de_serie, String titularidad, String estado_de_matricula, Date fecha_de_registro){
        this.matricula = matricula;
        this.tipo_matricula = tipo_matricula;
        this.estado_de_matricula = estado_de_matricula;
        this.fecha_de_registro = fecha_de_registro;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.numero_de_serie = numero_de_serie;
        this.titularidad = titularidad;
    }

    public void UpdateAeronave(String estado_de_matricula, Date fecha_de_registro, String titularidad){
        this.estado_de_matricula = estado_de_matricula;
        this.fecha_de_registro = fecha_de_registro;
        this.titularidad = titularidad;
    }

    public String getMatricula(){
        return matricula;
    }

    public String getTipo_matricula(){
        return tipo_matricula;
    }

    public String getEstadoMatricula(){
        return estado_de_matricula;
    }

    public Date getFechaRegistro(){
        return fecha_de_registro;
    }

    public String getFabricante(){
        return fabricante;
    }

    public String getModelo(){
        return modelo;
    }

    public String getNumeroSerie(){
        return numero_de_serie;
    }

    public String getTitularidad(){
        return titularidad;
    }
}