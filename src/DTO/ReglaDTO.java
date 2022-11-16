package DTO;

import model.enums.TipoRango;

public class ReglaDTO {
    public int codigo;
    public TipoRango tipoRango;

    @Override
    public String toString() {
        return "codigo=" + codigo;
    }

    public boolean valorBooleano;
    public double valorCritico;
    public double valorReservado;

    public ReglaDTO(int codigo) {
        this.codigo = codigo;
    }

}
