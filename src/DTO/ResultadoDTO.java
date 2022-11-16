package DTO;

import model.Peticiones;

public class ResultadoDTO {
    public int ID;
    public int valorNumerico;
    public boolean valorBooleano;
    public PeticionesDTO peticion;

    @Override
    public String toString() {
        return "ID=" + ID;
    }

    public ResultadoDTO(int ID, PeticionesDTO peticion) {
        this.ID = ID;
        this.peticion = peticion;
    }
}
