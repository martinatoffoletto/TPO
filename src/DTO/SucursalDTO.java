package DTO;

import model.Paciente;
import model.Peticiones;
import model.Practicas;

import java.util.List;

public class SucursalDTO {
    public int numero ;
    public String direccion;
    public String responsableTecnico;


    @Override
    public String toString() {
        return "Numero= " + numero +
                " Direccion= " + direccion;
    }

    public SucursalDTO(int numero, String direccion, String responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }
}
