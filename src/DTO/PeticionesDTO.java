package DTO;

import model.Paciente;
import model.Practicas;
import model.Sucursal;
import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.List;

public class PeticionesDTO {
    public Paciente paciente;
    public Sucursal sucursal;
    public String ObraSocial;
    public String fechaCarga;
    public List<Practicas> practicasAsociadas;
    public String fechaEntrega;
    public TipoEstado estado;
    public int nroPeticion;

    public PeticionesDTO(Paciente paciente, Sucursal sucursal, String obraSocial, String fechaCarga, List<Practicas> practicasAsociadas, String fechaEntrega, TipoEstado estado, int nroPeticion) {
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
