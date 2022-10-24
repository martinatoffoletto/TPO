package model;

import model.enums.TipoRol;

import java.time.LocalDate;

public class UsuarioSistema {
    String usuario;
    String email ;
    String password;
    String nombre;
    String domicilio;
    int DNI;
    LocalDate nacimiento;
    TipoRol rol;

}
