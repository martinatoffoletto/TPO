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
    private  ArrayList<Practicas> listaPracticas;
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
        for (UsuarioSistema usuario: listaUsuarios ) {
            if (usuario.getUsuario() == usuMod.usuario) {
                if (usuMod.usuario != null) {
                    usuario.setUsuario(usuMod.usuario);
                }
                if (usuMod.email != null) {
                    usuario.setEmail(usuMod.email);
                }
                if (usuMod.password != null) {
                    usuario.setPassword(usuMod.password);
                }
                if (usuMod.nombre != null) {
                    usuario.setNombre(usuMod.nombre);
                }
                if (usuMod.domicilio != null) {
                    usuario.setDomicilio(usuMod.domicilio);
                }
                if (usuMod.nacimiento != null) {
                    usuario.setNacimiento(usuMod.nacimiento);
                }
                if (usuMod.rol != null) {
                    usuario.setRol(usuMod.rol);
                }
            }
            break;
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
                practicaDTO.valoresCriticos, practicaDTO.valoresReservados, practicaDTO.horasResultado, practicaDTO.regla);
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
            if (practica.getCodigo() == practicasDTO.codigo) {

                if (practicasDTO.valoresReservados != null) {
                    practica.setValoresReservados(practicasDTO.valoresReservados);
                }
                if (practicasDTO.nombrePractica != null) {
                    practica.setNombrePractica(practicasDTO.nombrePractica);
                }
                if (practicasDTO.valoresCriticos != null) {
                    practica.setValoresCriticos(practicasDTO.valoresCriticos);
                }
                if (practicasDTO.grupo != null) {
                    practica.setGrupo(practicasDTO.grupo);
                }
                break;
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
