package DTO;

import model.enums.TipoEstado;

public class PeticionPracticaDTO {
    public TipoEstado estadoPractica;

    public PeticionPracticaDTO(TipoEstado estadoPractica) {
        this.estadoPractica = estadoPractica;
    }
}
