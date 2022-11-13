package model;

import model.enums.TipoRango;

import java.util.List;

public class Regla {
    private int codigo;
    private TipoRango tipoRango;
    private boolean valorBooleano;
    private List<String> listaPalabras;
    private double valor;

    public Regla(int codigo, TipoRango tipoRango, boolean valorBooleano, List<String> listaPalabras, double valor) {
        this.codigo = codigo;
        this.tipoRango = tipoRango;
        this.valorBooleano = valorBooleano;
        this.listaPalabras = listaPalabras;
        this.valor = valor;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
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
