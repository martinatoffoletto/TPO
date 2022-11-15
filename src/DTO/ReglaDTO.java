package DTO;

import model.enums.TipoRango;
import model.enums.TipoValor;

import java.util.List;

public class ReglaDTO {
    public int codigo;
    public TipoValor tipoValor;
    public TipoRango tipoRango;

    @Override
    public String toString() {
        return "codigo=" + codigo;
    }

    public boolean valorBooleano;
    public double valor;

    public ReglaDTO(int codigo) {
        this.codigo = codigo;
    }

}
