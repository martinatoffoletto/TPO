package controller;

import DTO.PracticasDTO;
import DTO.UsuarioSistemaDTO;
import model.Peticiones;
import model.Practicas;
import model.Sucursal;
import model.UsuarioSistema;
import model.enums.TipoRol;
import controller.*;
import model.enums.TipoValor;

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
    public ControllerParametros() {
        listaUsuarios= new ArrayList<UsuarioSistema>();
        listaPracticas= new ArrayList<Practicas>();

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
                usuario.setUsuario(usuMod.usuario);}
            if (usuario.getEmail() == null){
                usuario.setEmail(usuMod.email);}
            if (usuario.getPassword() == null){
                usuario.setPassword(usuMod.password);}
            if (usuario.getNombre() == null){
                usuario.setNombre(usuMod.nombre);}
            if (usuario.getDomicilio() == null){
                usuario.setDomicilio(usuMod.domicilio);}
            if (usuario.getDNI() == null){
                usuario.setDNI(usuMod.DNI);}
            if (usuario.getNacimiento() == null){
                usuario.setNacimiento(usuMod.nacimiento);}
            if (usuario.getRol() == null){
                usuario.setRol(usuMod.rol);}
                break;

            }
        }
    }
    //DATOS USUARIO
    public void datosUsuario(UsuarioSistemaDTO usuBaja) {
        for (UsuarioSistema usuario: listaUsuarios) {
            if (usuario.getUsuario() == usuBaja.usuario)
                String email= usuario.getEmail();
                String nombre= usuario.getNombre();
                String domicilio= usuario.getDomicilio();
                int dni =usuario.getDNI();
                LocalDate nacimiento= usuario.getNacimiento();
                TipoRol rol=usuario.getRol();
        }
    }


    //ALTA PRACTICA
    public void altaPractica(PracticasDTO practicaDTO) {
        Practicas practica = new Practicas(practicaDTO.codigo, practicaDTO.nombrePractica, practicaDTO.grupo,
                practicaDTO.valoresCriticos, practicaDTO.valoresReservados, practicaDTO.horasResultado);
        listaPracticas.add(practica);
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
            if (practica.getCodigo() == practicasDTO.codigo) {
                practica.setCodigo(practicasDTO.codigo);}
            if (practica.getValoresReservados() == null){
                practica.setValoresReservados(practicasDTO.valoresReservados);}
            if (practica.getNombrePractica() == null){
                practica.setNombrePractica(practicasDTO.nombrePractica);}
            if (practica.getValoresCriticos() == null){
                practica.setValoresCriticos(practicasDTO.valoresCriticos);}
            if (practica.getHorasResultado() == null){
                practica.setHorasResultado(practicasDTO.horasResultado);}
            if (practica.getGrupo() == null){
                practica.setGrupo(practicasDTO.grupo);}
            break;

            }
        }



    //DATOS PRACTICA
    public void datosPractica(PracticasDTO practicasDTO) {

        for (Practicas practica: listaPracticas ) {
            if (practica.getCodigo() == practicasDTO.codigo) {
                int codigo=practica.getCodigo();
                String nombrePractia=practica.getNombrePractica();
                String grupo=practica.getGrupo();
                TipoValor valoresCriticos= practica.getValoresCriticos();
                String valoresReservados= practica.getValoresReservados();
                int horasResult=practica.getHorasResultado();
                boolean estado=practica.getEstado();
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
