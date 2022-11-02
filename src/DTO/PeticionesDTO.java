package DTO;

import model.Paciente;
import model.enums.TipoEstado;

import java.time.LocalDate;

public class PeticionesDTO {
    public Paciente paciente;
    public String ObraSocial;
    public LocalDate fechaCarga;
    public String practicasAsociadas;
    public LocalDate fechaEntrega;
    public TipoEstado estado;
    public int nroPeticion;

    public PeticionesDTO(Paciente paciente, String obraSocial, LocalDate fechaCarga, String practicasAsociadas, LocalDate fechaEntrega, TipoEstado estado, int nroPeticion) {
        this.paciente = paciente;
        ObraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.practicasAsociadas = practicasAsociadas;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
    }
}
