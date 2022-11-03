package DTO;

import model.Paciente;
import model.Peticiones;
import model.Practicas;

import java.util.List;

public class SucursalDTO {
    public int numero ;
    public String direccion;
    public String responsableTecnico;
    public List<Practicas> listaPractica;
    public   List<Peticiones> listaPeticiones;
    public   List<Paciente> listaPacientes;

    public SucursalDTO(int numero, String direccion, String responsableTecnico ,List<Peticiones> listaPeticiones,List<Practicas> listaPractica,List<Paciente> listaPacientes) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
        this.listaPeticiones=listaPeticiones;
        this.listaPractica=listaPractica;
        this.listaPacientes=listaPacientes;

    }
}
