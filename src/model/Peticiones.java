package model;

import model.enums.TipoEstado;

public class Peticiones {
    private Paciente paciente;
    private String obraSocial;
    private String fechaCarga;
    private Practicas practicaAsociada;
    private String fechaEntrega;
    private TipoEstado estado;
    private int nroPeticion;
    private Sucursal sucursal;
    private Resultado resultado;


    //CONSTRUCTOR
    public Peticiones(Paciente paciente, Sucursal sucursal, Practicas practicaAsociada, String obraSocial, String fechaCarga, String fechaEntrega, TipoEstado estado, int nroPeticion) {
        this.obraSocial = obraSocial;
        this.practicaAsociada = practicaAsociada;
        this.fechaCarga = fechaCarga;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
        this.sucursal=sucursal;
        this.paciente=paciente;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
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
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
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
