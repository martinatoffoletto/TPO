package controller;

import DTO.PracticasDTO;
import DTO.UsuarioSistemaDTO;
import model.Peticiones;
import model.Practicas;
import model.Sucursal;
import model.UsuarioSistema;
import model.enums.TipoRol;
import controller.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerParametros {
    public ArrayList<PracticasDTO> getListaPracticasDTO() {
        return listaPracticasDTO;
    }

    private static ControllerParametros instancia;
    private ArrayList<UsuarioSistema> listaUsuarios;
    private  ArrayList<Practicas> listaPracticas;
    public ArrayList<PracticasDTO> listaPracticasDTO;


    //SINGLETON
    public static ControllerParametros getInstancia() {
        if (instancia == null)
            instancia = new ControllerParametros();
        return instancia;
    }


    //CONSTRUCTOR
    public ControllerParametros() {
        listaUsuarios= new ArrayList<UsuarioSistema>();
        listaPracticas= new ArrayList<Practicas>();
        listaPracticasDTO = new ArrayList<PracticasDTO>();
    }

    //METODOS:

    //ALTA USUARIOS
    public void altaUsuario(UsuarioSistemaDTO usuario) {
        UsuarioSistema usuarioSistema = new UsuarioSistema(usuario.usuario,usuario.email,usuario.password,
                usuario.nombre,usuario.domicilio,usuario.DNI,usuario.nacimiento,usuario.rol);
        listaUsuarios.add(usuarioSistema);
    }

    //BAJA USUARIOS
    public void bajaUsuario(UsuarioSistemaDTO usuBaja) {
        for (UsuarioSistema usuario: listaUsuarios) {
            if (usuario.getUsuario() == usuBaja.usuario)
                listaUsuarios.remove(usuario);
        }
    }


    //MODIFICACION USUARIOS
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
    //DATOS USUARIO
    public void datosUsuario(UsuarioSistemaDTO usuBaja) {
        for (UsuarioSistema usuario: listaUsuarios) {
            if (usuario.getUsuario() == usuBaja.usuario)
                usuario.getNombre();
                usuario.getDNI();
                usuario.getDomicilio();
                usuario.getEmail();
                usuario.getNacimiento();
                usuario.getRol();
        }
    }


    //ALTA PRACTICA
    public void altaPractica(PracticasDTO practicaDTO) {
        Practicas practica = new Practicas(practicaDTO.codigo, practicaDTO.nombrePractica, practicaDTO.grupo,
                practicaDTO.valoresCriticos, practicaDTO.valoresReservados, practicaDTO.horasResultado);
        listaPracticas.add(practica);
        listaPracticasDTO.add(practicaDTO);
    }

    //BAJA PRACTICA
    public void bajaPractica(PracticasDTO practicasDTO) { //REGLA DE NEGOCIO
        Practicas practBja= null;
        boolean usado= false;
        for (Practicas practicas: listaPracticas) {
            if (practicas.getCodigo() == practicasDTO.codigo)
                practBja=practicas;
        }
        for (Peticiones p : ControllerPeticiones.getListaPeticiones()){
            for (Practicas pract: p.getPracticasAsociadas()){
                if (pract==practBja){
                    usado=true;
                }
            }
        }
        if(usado){ //INHABILITAR
            practBja.EstadoFalso();
        }else {
            listaPracticas.remove(practBja);

        }
    }


    //MODIF PRACTICA
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

    //DATOS PRACTICA
    public void datosPractica(PracticasDTO practicasDTO) {

        for (Practicas practica: listaPracticas ) {
            if (practica.getCodigo() == practicasDTO.codigo) {
                practica.getCodigo();
                practica.getGrupo();
                practica.getHorasResultado();
                practica.getNombrePractica();
                practica.getValoresCriticos();
                practica.getValoresReservados();
                practica.getEstado();

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
