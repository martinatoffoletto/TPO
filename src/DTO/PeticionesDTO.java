package DTO;

import model.Paciente;
import model.Practicas;
import model.Sucursal;
import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.List;

public class PeticionesDTO {
    public Paciente paciente;
    public String ObraSocial;
    public LocalDate fechaCarga;
    public List<Practicas> practicasAsociadas;
    public LocalDate fechaEntrega;
    public TipoEstado estado;
    public int nroPeticion;
    public Sucursal sucursal;

    public PeticionesDTO(Paciente paciente, String obraSocial, LocalDate fechaCarga, List<Practicas> practicasAsociadas, LocalDate fechaEntrega, TipoEstado estado, int nroPeticion,  Sucursal sucursal) {
        this.paciente = paciente;
        this.ObraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.practicasAsociadas = practicasAsociadas;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nroPeticion = nroPeticion;
        this.sucursal=sucursal;
    }
}
