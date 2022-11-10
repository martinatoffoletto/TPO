package DTO;

import model.Paciente;
import model.Peticiones;
import model.Practicas;

import java.util.List;

public class SucursalDTO {
    public int numero ;
    public String direccion;
    public String responsableTecnico;


    public SucursalDTO(int numero, String direccion, String responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }

    @Override
    public String toString() {
        return
                "Número = " + numero + " Dirección = " + direccion;
    }
}
