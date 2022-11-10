package DTO;

import model.Peticiones;

import java.util.ArrayList;

public class PacienteDTO {
    public String DNI;
    public String nombre;
    public String domicilio;
    public String mail;
    public String sexo;
    public int edad;
    public ArrayList<Peticiones> listaPeticionesPaciente;



    //CONSTRUCTOR
    public PacienteDTO(String DNI, String nombre, String domicilio, String mail, String sexo, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
        listaPeticionesPaciente= new ArrayList<Peticiones>();

    }
}
