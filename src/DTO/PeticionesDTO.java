package DTO;

import model.Paciente;
import model.enums.TipoEstado;

import java.time.LocalDate;

public class PeticionesDTO {
    Paciente paciente;
    String ObraSocial;
    LocalDate fechaCarga;
    String practicasAsociadas;
    LocalDate fechaEntrega;
    TipoEstado estado;
    int nroPeticion;

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
