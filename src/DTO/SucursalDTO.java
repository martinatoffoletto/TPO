package DTO;

import model.Paciente;
import model.Peticiones;
import model.Practicas;

import java.util.List;

public class SucursalDTO {
    public int numero ;
    public String direccion;
    public UsuarioSistemaDTO responsableTecnico;


    @Override
    public String toString() {
        return "Número: " + numero + " Dirección: " + direccion;
    }

    public SucursalDTO(int numero, String direccion, UsuarioSistemaDTO responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }
}
