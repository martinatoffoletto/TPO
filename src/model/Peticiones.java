package model;

import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Peticiones {
    public Paciente paciente;
    public String ObraSocial;
    public LocalDate fechaCarga;
    public List<Practicas> practicasAsociadas;
    public LocalDate fechaEntrega;
    public TipoEstado estado;
    public int nroPeticion;
    public Sucursal sucursal;


    //CONSTRUCTOR
    public Peticiones(Paciente paciente, String obraSocial, LocalDate fechaCarga, LocalDate fechaEntrega, TipoEstado estado, int nroPeticion,Sucursal sucursal) {
        this.paciente = paciente;
        ObraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
        this.sucursal=sucursal;
        practicasAsociadas= new ArrayList<Practicas>();
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

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDate fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public List<Practicas> getPracticasAsociadas() {
        return practicasAsociadas;
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


    //METODOS:
    public void AgregarPractica(Practicas p){
        practicasAsociadas.add(p);

    }
}
