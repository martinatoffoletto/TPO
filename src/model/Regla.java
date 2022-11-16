package model;

import model.enums.TipoRango;
import model.enums.TipoValor;

public class Regla {
    private int codigo;
    private TipoValor tipoValor;
    private TipoRango tipoRango;

    public TipoValor getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(TipoValor tipoValor) {
        this.tipoValor = tipoValor;
    }

    private boolean valorBooleano;
    private double valorCritico;
    private double valorReservado;

    public double getValorReservado() {
        return valorReservado;
    }

    public void setValorReservado(double valorReservado) {
        this.valorReservado = valorReservado;
    }

    public Regla(int codigo) {
        this.codigo = codigo;
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

    public double getValorCritico() {
        return valorCritico;
    }

    public void setValorCritico(double valorCritico) {
        this.valorCritico = valorCritico;
    }

}
