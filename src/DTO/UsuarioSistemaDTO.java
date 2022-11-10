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
    public LocalDate nacimiento;
    public TipoRol rol;

    @Override
    public String toString() {
        return "usuario='" + usuario;
    }

    public UsuarioSistemaDTO(String usuario, String email, String password, String nombre, String domicilio, int DNI, LocalDate nacimiento, TipoRol rol) {
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
