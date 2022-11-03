package model;

import model.enums.TipoValor;

public class Practicas {
    private int codigo;
    private String nombrePractica;
    private String grupo;
    private TipoValor valoresCriticos;
    private String valoresReservados;
    private int horasResultado;


    //CONSTRUCTOR
    public Practicas(int codigo, String nombrePractica, String grupo, TipoValor valoresCriticos, String valoresReservados, int horasResultado) {
        this.codigo = codigo;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.valoresCriticos = valoresCriticos;
        this.valoresReservados = valoresReservados;
        this.horasResultado = horasResultado;
    }

    //GETTER AND SETTER
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public TipoValor getValoresCriticos() {
        return valoresCriticos;
    }

    public void setValoresCriticos(TipoValor valoresCriticos) {
        this.valoresCriticos = valoresCriticos;
    }

    public String getValoresReservados() {
        return valoresReservados;
    }

    public void setValoresReservados(String valoresReservados) {
        this.valoresReservados = valoresReservados;
    }

    public int getHorasResultado() {
        return horasResultado;
    }

    public void setHorasResultado(int horasResultado) {
        this.horasResultado = horasResultado;
    }



}
