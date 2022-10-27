package model;

import model.enums.TipoRango;

import java.util.List;

public class Regla {
    TipoRango tipoRango;
    boolean valorBooleano;
    List<String> listaPalabras;
    double valor;

    public Regla(TipoRango tipoRango, boolean valorBooleano, List<String> listaPalabras, double valor) {
        this.tipoRango = tipoRango;
        this.valorBooleano = valorBooleano;
        this.listaPalabras = listaPalabras;
        this.valor = valor;
    }

    public TipoRango getTipoRango() {
        return tipoRango;
    }

    public void setTipoRango(TipoRango tipoRango) {
        this.tipoRango = tipoRango;
    }

    public boolean isValorBooleano() {
        return valorBooleano;
    }

    public void setValorBooleano(boolean valorBooleano) {
        this.valorBooleano = valorBooleano;
    }

    public List<String> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(List<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
