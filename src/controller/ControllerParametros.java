package controller;

import DTO.PracticasDTO;
import DTO.ReglaDTO;
import DTO.UsuarioSistemaDTO;
import model.*;
import model.enums.TipoRol;
import controller.*;
import model.enums.TipoValor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerParametros {
    public ArrayList<PracticasDTO> getListaPracticasDTO() {
        return listaPracticasDTO;
    }

    private static ControllerParametros instancia;
    private ArrayList<UsuarioSistema> listaUsuarios;
    public   ArrayList<Practicas> listaPracticas;
    private ArrayList<Regla> listaReglas;
    public ArrayList<PracticasDTO> listaPracticasDTO;
    public ArrayList<UsuarioSistemaDTO> listaUsuariosDTO;
    public ArrayList<ReglaDTO> listaReglaDTO;
    public ArrayList<UsuarioSistemaDTO> getListaUsuariosDTO() {return listaUsuariosDTO; }
    public ArrayList<ReglaDTO> getListaReglaDTO() {return listaReglaDTO;}


    //SINGLETON
    public static ControllerParametros getInstancia() {
        if (instancia == null)
            instancia = new ControllerParametros();
        return instancia;
    }

    public ArrayList<Practicas> getListaPracticas() {
        return listaPracticas;
    }

    //CONSTRUCTOR
    public ControllerParametros() {
        listaUsuarios= new ArrayList<UsuarioSistema>();
        listaPracticas= new ArrayList<Practicas>();
        listaReglas  = new ArrayList<Regla>();
        listaPracticasDTO = new ArrayList<PracticasDTO>();
        listaUsuariosDTO = new ArrayList<UsuarioSistemaDTO>();
        listaReglaDTO = new ArrayList<ReglaDTO>();
    }

    //METODOS:

    //ALTA USUARIOS
    public void altaUsuario(UsuarioSistemaDTO usuario) {
        UsuarioSistema usuarioSistema = new UsuarioSistema(usuario.usuario, usuario.email, usuario.password,
                usuario.nombre, usuario.domicilio, usuario.DNI, usuario.nacimiento, usuario.rol);
        listaUsuarios.add(usuarioSistema);
        listaUsuariosDTO.add(usuario);

    }

    //BAJA USUARIOS
    public void bajaUsuario(UsuarioSistemaDTO usuBaja) {
        for (UsuarioSistema usuario: listaUsuarios) {
            if (usuario.getUsuario() == usuBaja.usuario)
                listaUsuarios.remove(usuario);
            listaUsuariosDTO.remove(usuBaja);
        }
    }


    //MODIFICACION USUARIOS
    public void modificacionUsuario(UsuarioSistemaDTO usuMod) {
        for (UsuarioSistemaDTO usuarioSistemaDTO: listaUsuariosDTO)
            if (usuarioSistemaDTO.DNI == usuMod.DNI) {
                usuarioSistemaDTO.usuario=usuMod.usuario;
                usuarioSistemaDTO.email=usuMod.email;
                usuarioSistemaDTO.password=usuMod.password;
                usuarioSistemaDTO.nombre=usuMod.nombre;
                usuarioSistemaDTO.domicilio=usuMod.domicilio;
                usuarioSistemaDTO.nacimiento= usuMod.nacimiento;
                usuarioSistemaDTO.rol=usuMod.rol;
            }
        for (UsuarioSistema usuario: listaUsuarios ) {
            if (usuario.getUsuario() == usuMod.usuario) {
                usuario.setUsuario(usuMod.usuario);
                usuario.setEmail(usuMod.email);
                usuario.setPassword(usuMod.password);
                usuario.setNombre(usuMod.nombre);
                usuario.setDomicilio(usuMod.domicilio);
                usuario.setNacimiento(usuMod.nacimiento);
                usuario.setRol(usuMod.rol);
            }
        }
    }

    //DATOS USUARIO
    /*public void datosUsuario(UsuarioSistemaDTO usuDatos) {
        for (UsuarioSistema usuario: listaUsuarios) {
            if (usuario.getUsuario() == usuDatos.usuario)
                String email= usuario.getEmail();
                String nombre= usuario.getNombre();
                String domicilio= usuario.getDomicilio();
                int dni =usuario.getDNI();
                LocalDate nacimiento= usuario.getNacimiento();
                TipoRol rol=usuario.getRol();
        }
    }
*/

    //ALTA PRACTICA
    public void altaPractica(PracticasDTO practicaDTO) {
        Practicas practica = new Practicas(practicaDTO.codigo, practicaDTO.nombrePractica, practicaDTO.grupo,
                practicaDTO.valoresCriticos, practicaDTO.valoresReservados, practicaDTO.horasResultado);
        for (Regla regla: listaReglas)
            if (regla.getCodigo() == practicaDTO.regla.codigo)
                practica.setRegla(regla);
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
        for (Peticiones p : ControllerPeticiones.getInstancia().getListaPeticiones()){
            if (p.getPracticaAsociada().getCodigo() == practicasDTO.codigo) {
                usado = true;
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
        for (PracticasDTO practicasDTO1: listaPracticasDTO)
            if (practicasDTO1.codigo==practicasDTO.codigo) {
                practicasDTO1.codigo=practicasDTO.codigo;
                practicasDTO1.valoresCriticos=practicasDTO.valoresCriticos;
                practicasDTO1.valoresReservados=practicasDTO.valoresReservados;
                practicasDTO1.grupo=practicasDTO.grupo;
            }
        for (Practicas practica: listaPracticas ) {
            if (practica.getCodigo() == practicasDTO.codigo) {
                practica.setValoresReservados(practicasDTO.valoresReservados);
                practica.setNombrePractica(practicasDTO.nombrePractica);
                practica.setValoresCriticos(practicasDTO.valoresCriticos);
                practica.setGrupo(practicasDTO.grupo);
            }

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
                TipoValor valoresReservados= practica.getValoresReservados();
                int horasResult=practica.getHorasResultado();
                boolean estado=practica.getEstado();
            }
        }
    }

    public void altaRegla(ReglaDTO reglaDTO) {
        Regla regla = new Regla(reglaDTO.codigo, reglaDTO.tipoRango, reglaDTO.valorBooleano, reglaDTO.listaPalabras, reglaDTO.valor);
        listaReglas.add(regla);
        listaReglaDTO.add(reglaDTO);
    }

    public void modificarRegla(ReglaDTO reglaDTO) {
        for (ReglaDTO reglaDTO1: listaReglaDTO)
            if (reglaDTO1.codigo==reglaDTO.codigo) {
                reglaDTO1.codigo=reglaDTO.codigo;
                reglaDTO1.tipoRango=reglaDTO.tipoRango;
                reglaDTO1.valorBooleano=reglaDTO.valorBooleano;
                reglaDTO1.listaPalabras=reglaDTO.listaPalabras;
                reglaDTO1.valor=reglaDTO.valor;
            }
        for (Regla regla: listaReglas)
            if (regla.getCodigo() == reglaDTO.codigo){
                regla.setCodigo(reglaDTO.codigo);
                regla.setTipoRango(reglaDTO.tipoRango);
                regla.setValorBooleano(reglaDTO.valorBooleano);
                regla.setListaPalabras(reglaDTO.listaPalabras);
                regla.setValor(reglaDTO.valor);
            }
    }

    public void bajaRegla(ReglaDTO reglaDTO) {
        for (Regla regla: listaReglas)
            if (regla.getCodigo() == reglaDTO.codigo) {
                listaReglas.remove(regla);
                listaReglaDTO.remove(reglaDTO);
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
