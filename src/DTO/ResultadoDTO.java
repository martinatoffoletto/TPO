package DTO;

public class ResultadoDTO {
    public int ID;
    public int valorNumerico;
    public boolean valorBooleano;

    @Override
    public String toString() {
        return "ID=" + ID;
    }

    public String descripcion;
    public ResultadoDTO(int ID) {
        this.ID = ID;
    }
}
