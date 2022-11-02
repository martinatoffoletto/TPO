package DTO;

public class SucursalDTO {
    public int numero ;
    public String direccion;
    public String responsableTecnico;

    public SucursalDTO(int numero, String direccion, String responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }
}
