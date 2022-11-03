package model;

import java.util.List;

public class Sucursal {
    private int numero ;
    private String direccion;
    private String responsableTecnico;
    private List<Paciente> listaPaciente;

    public int agregarPaciente(Paciente p)
    {
        listaPaciente.add(p);
        return listaPaciente.size();
    }
    public Sucursal(int numero, String direccion, String responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getResponsableTecnico() {
        return responsableTecnico;
    }

    public void setResponsableTecnico(String responsableTecnico) {
        this.responsableTecnico = responsableTecnico;
    }
}
