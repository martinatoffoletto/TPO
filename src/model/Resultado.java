package model;

public class Resultado {
    private int ID;
    private int valorNumerico;
    private boolean valorBooleano;
    private Peticiones peticion;
    public Resultado(int ID, int valorNumerico, boolean valorBooleano, Peticiones peticion) {
        this.ID = ID;
        this.valorNumerico = valorNumerico;
        this.valorBooleano = valorBooleano;
        this.peticion = peticion;
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


    public int getID() {
        return ID;
    }

    public Peticiones getPeticion() {
        return peticion;
    }

    public void setPeticion(Peticiones peticion) {
        this.peticion = peticion;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean esResultadoCritico() {
        boolean esCritico = false;
        return esCritico;
    }

    public boolean esResultadoReservado() {
        boolean esReservado = false;
        return esReservado;
    }
}
