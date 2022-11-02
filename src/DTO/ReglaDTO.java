package DTO;

import model.enums.TipoRango;

import java.util.List;

public class ReglaDTO {
    public TipoRango tipoRango;
    public boolean valorBooleano;
    public List<String> listaPalabras;
    public double valor;

    public ReglaDTO(TipoRango tipoRango, boolean valorBooleano, List<String> listaPalabras, double valor) {
        this.tipoRango = tipoRango;
        this.valorBooleano = valorBooleano;
        this.listaPalabras = listaPalabras;
        this.valor = valor;
    }
}
