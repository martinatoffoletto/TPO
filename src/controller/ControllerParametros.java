package controller;

import DTO.PracticasDTO;
import DTO.UsuarioSistemaDTO;
import model.Practicas;
import model.UsuarioSistema;
import model.enums.TipoRol;

import java.time.LocalDate;
import java.util.List;

public class ControllerParametros {

    private static ControllerParametros instancia;

    public static ControllerParametros getInstancia() {
        if (instancia == null)
            instancia = new ControllerParametros();
        return instancia;
    }

    private ControllerParametros() {

    }
    private static List<UsuarioSistema> listaUsuarios;
    private static List<Practicas> listaPracticas;

    public void altaUsuario(UsuarioSistemaDTO usuario) {
        UsuarioSistema usuarioSistema = new UsuarioSistema(usuario.usuario,usuario.email,usuario.password,
                usuario.nombre,usuario.domicilio,usuario.DNI,usuario.nacimiento,usuario.rol);
        listaUsuarios.add(usuarioSistema);
    }

    public void bajaUsuario(UsuarioSistemaDTO usuBaja) {
        for (UsuarioSistema usuario: listaUsuarios) {
            if (usuario.getUsuario() == usuBaja.usuario)
                listaUsuarios.remove(usuario);
        }
    }

    public void modificacionUsuario(UsuarioSistemaDTO usuMod) {
        for (UsuarioSistema usuario: listaUsuarios ) {
            if (usuario.getUsuario() == usuMod.usuario)
            {
                usuario.setUsuario(usuMod.usuario);
                usuario.setEmail(usuMod.email);
                usuario.setPassword(usuMod.password);
                usuario.setNombre(usuMod.nombre);
                usuario.setDomicilio(usuMod.domicilio);
                usuario.setDNI(usuMod.DNI);
                usuario.setNacimiento(usuMod.nacimiento);
                usuario.setRol(usuMod.rol);
                break;

            }
        }
    }

    public void altaPractica(PracticasDTO practicaDTO) {
        Practicas practica = new Practicas(practicaDTO.codigo, practicaDTO.nombrePractica, practicaDTO.grupo,
                practicaDTO.valoresCriticos, practicaDTO.valoresReservados, practicaDTO.horasResultado);
        listaPracticas.add(practica);
    }

    public void bajaPractica() {

    }

    public void modificacionPractica() {

    }

    public void altaSucursal() {

    }

    public void bajaSucursal() {

    }
    public void modificacionSucursal() {

    }
}
