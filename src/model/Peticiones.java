package model;

import model.enums.TipoEstado;

import java.time.LocalDate;

public class Peticiones {
    Paciente paciente;
    String ObraSocial;
    LocalDate fechaCarga;
    String practicasAsociadas;
    LocalDate fechaEntrega;
    TipoEstado estado;
    int nroPeticion;

    public Peticiones(Paciente paciente, String obraSocial, LocalDate fechaCarga, String practicasAsociadas, LocalDate fechaEntrega, TipoEstado estado, int nroPeticion) {
        this.paciente = paciente;
        ObraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.practicasAsociadas = practicasAsociadas;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getObraSocial() {
        return ObraSocial;
    }

    public void setObraSocial(String obraSocial) {
        ObraSocial = obraSocial;
    }

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDate fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getPracticasAsociadas() {
        return practicasAsociadas;
    }

    public void setPracticasAsociadas(String practicasAsociadas) {
        this.practicasAsociadas = practicasAsociadas;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public int getNroPeticion() {
        return nroPeticion;
    }

    public void setNroPeticion(int nroPeticion) {
        this.nroPeticion = nroPeticion;
    }
}
