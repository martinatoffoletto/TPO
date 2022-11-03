package model;

import DTO.PracticasDTO;

import java.util.List;

public class Sucursal {
    private int numero ;
    private String direccion;
    private String responsableTecnico;
    private  List<Practicas> listaPractica;
    private  List<Peticiones> listaPeticiones;

    private List<Paciente> listaPacientes;

    //CONSTRUCTOR
    public Sucursal(int numero, String direccion, String responsableTecnico ,List<Peticiones> listaPeticiones,List<Practicas> listaPractica,List<Paciente> listaPacientes) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
        this.listaPeticiones=listaPeticiones;
        this.listaPractica=listaPractica;
        this.listaPacientes=listaPacientes;
    }

    //GETTER Y SETTER

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    public List<Peticiones> getListaPeticiones() {
        return listaPeticiones;
    }

    public void setListaPeticiones(List<Peticiones> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
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

    public List<Practicas> getListaPractica() {
        return listaPractica;
    }

    public void setListaPractica(List<Practicas> listaPractica) {
        this.listaPractica = listaPractica;
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
    public int agregarPractica(Practicas p){
        listaPractica.add(p);
        return listaPractica.size();
    }




}
