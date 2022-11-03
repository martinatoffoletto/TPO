package controller;

import DTO.PracticasDTO;
import DTO.UsuarioSistemaDTO;
import model.Practicas;
import model.UsuarioSistema;
import model.enums.TipoRol;
import controller.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerParametros {
    private static ControllerParametros instancia;
    private static List<UsuarioSistema> listaUsuarios;
    private static List<Practicas> listaPracticas;


    //SINGLETON
    public static ControllerParametros getInstancia() {
        if (instancia == null)
            instancia = new ControllerParametros();
        return instancia;
    }


    //CONSTRUCTOR
    private ControllerParametros() {
        listaUsuarios= new ArrayList<UsuarioSistema>();
        listaPracticas= new ArrayList<Practicas>();

    }

    //METODOS:
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

    public void bajaPractica(PracticasDTO practicasDTO) {
        for (Practicas practicas: listaPracticas) {
            if (practicas.getCodigo() == practicasDTO.codigo)
                listaPracticas.remove(practicas);
        }

    }

    public void modificacionPractica(PracticasDTO practicasDTO) {
        for (Practicas practica: listaPracticas ) {
            if (practica.getCodigo() == practicasDTO.codigo)
            {
                practica.setValoresReservados(practicasDTO.valoresReservados);
                practica.setNombrePractica(practicasDTO.nombrePractica);
                practica.setValoresCriticos(practicasDTO.valoresCriticos);
                practica.setCodigo(practicasDTO.codigo);
                practica.setHorasResultado(practicasDTO.horasResultado);
                practica.setGrupo(practicasDTO.grupo);
            break;

            }
        }

    }

    //METODOS:

    //EXISTE USUARIO (INICIO SECCION)
    public boolean InicioSeccion(UsuarioSistemaDTO userd){ //si es true muestra menu, sino NO (ver en vista)
        for (UsuarioSistema user:listaUsuarios){
            if (user.getUsuario()==userd.usuario && user.getPassword()==userd.password){
                return true;
            }
        }
        return false;
    }










}
