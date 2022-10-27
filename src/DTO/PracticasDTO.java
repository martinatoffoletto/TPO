package DTO;

import model.enums.TipoValor;

public class PracticasDTO {
    public int codigo;
    public String nombrePractica;
    public String grupo;
    public TipoValor valoresCriticos;
    public String valoresReservados;
    public int horasResultado;

    public PracticasDTO(int codigo, String nombrePractica, String grupo, TipoValor valoresCriticos, String valoresReservados, int horasResultado) {
        this.codigo = codigo;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.valoresCriticos = valoresCriticos;
        this.valoresReservados = valoresReservados;
        this.horasResultado = horasResultado;
    }
}
