package DTO;

import model.enums.TipoRango;
import model.enums.TipoValor;

public class ReglaDTO {
    public int codigo;
    public TipoRango tipoRango;
    public TipoValor tipoValor;

    @Override
    public String toString() {
        return "codigo=" + codigo;
    }

    public boolean valorBooleano;
    public double valorCritico;
    public double valorReservado;

    public ReglaDTO(int codigo, TipoValor tipoValor) {
        this.codigo = codigo;
        this.tipoValor = tipoValor;
    }

}
