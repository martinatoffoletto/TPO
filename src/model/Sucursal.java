package model;

import DTO.PacienteDTO;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private int numero ;
    private String direccion;
    private String responsableTecnico;
    private  List<Peticiones> listaPeticiones;
    private List<Paciente> listaPacientes;

    //CONSTRUCTOR
    public Sucursal(int numero, String direccion, String responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
        listaPeticiones= new ArrayList<Peticiones>();
        listaPacientes= new ArrayList<Paciente>();
    }
    //GETTER Y SETTER

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public List<Peticiones> getListaPeticiones() {
        return listaPeticiones;
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



    //METODOS:
    public int agregarPeticion(Peticiones p)
    {
        listaPeticiones.add(p);
        return listaPeticiones.size();
    }

    public int agregarPaciente(Paciente p)
    {
        listaPacientes.add(p);
        return listaPacientes.size();
    }


}
