package model;

public class Resultado {
    private int ID;
    private int valorNumerico;
    private boolean valorBooleano;
    private String descripcion;

    public Resultado(int ID, int valorNumerico, boolean valorBooleano, String descripcion) {
        this.ID = ID;
        this.valorNumerico = valorNumerico;
        this.valorBooleano = valorBooleano;
        this.descripcion = descripcion;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public boolean isValorBooleano() {
        return valorBooleano;
    }

    public void setValorBooleano(boolean valorBooleano) {
        this.valorBooleano = valorBooleano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
