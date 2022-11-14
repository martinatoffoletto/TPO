package model;

import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Peticiones {
    private Paciente paciente;
    private String ObraSocial;
    private String fechaCarga;
    private Practicas practicaAsociada;
    private String fechaEntrega;
    private TipoEstado estado;
    private int nroPeticion;
    private Sucursal sucursal;


    //CONSTRUCTOR
    public Peticiones(String obraSocial, String fechaCarga, String fechaEntrega, TipoEstado estado, int nroPeticion) {
        ObraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
        this.sucursal=sucursal;
    }


    //SETTER Y GETTERS

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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

    public String getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Practicas getPracticaAsociada() {
        return practicaAsociada;
    }

    public void setPracticaAsociada(Practicas practicaAsociada) {
        this.practicaAsociada = practicaAsociada;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
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
