package DTO;

import model.Regla;
import model.enums.TipoValor;

public class PracticasDTO {
    public int codigo;
    public String nombrePractica;
    public String grupo;
    public TipoValor valoresCriticos;
    public TipoValor valoresReservados;
    public int horasResultado;
    public Regla regla;

    @Override
    public String toString() {
        return "Codigo = " + codigo + " Nombre Practica = " + nombrePractica;
    }

    public PracticasDTO(int codigo, String nombrePractica, String grupo, TipoValor valoresCriticos, TipoValor valoresReservados, int horasResultado, Regla regla) {
        this.codigo = codigo;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.valoresCriticos = valoresCriticos;
        this.valoresReservados = valoresReservados;
        this.horasResultado = horasResultado;
        this.regla = regla;
    }
}
