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
    public ReglaDTO regla;

    @Override
    public String toString() {
        return "Codigo = " + codigo + " Nombre Practica = " + nombrePractica + "Regla = " + regla;
    }

    public PracticasDTO(int codigo, String nombrePractica, String grupo, TipoValor valoresCriticos, TipoValor valoresReservados, int horasResultado, ReglaDTO regla) {
        this.codigo = codigo;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.valoresCriticos = valoresCriticos;
        this.valoresReservados = valoresReservados;
        this.horasResultado = horasResultado;
        this.regla = regla;
    }
}
