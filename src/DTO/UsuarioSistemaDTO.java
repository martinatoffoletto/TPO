package DTO;

import model.enums.TipoRol;
import java.time.LocalDate;

public class UsuarioSistemaDTO {
    public String usuario;
    public String email ;
    public String password;
    public String nombre;
    public String domicilio;
    public int DNI;
    public String nacimiento;
    public TipoRol rol;

    @Override
    public String toString() {
        return "Usuario: " + usuario + " Nombre: " + nombre;
    }

    public UsuarioSistemaDTO(String usuario, String email, String password, String nombre, String domicilio, int DNI, String nacimiento, TipoRol rol) {
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.nacimiento = nacimiento;
        this.rol = rol;
    }
}
