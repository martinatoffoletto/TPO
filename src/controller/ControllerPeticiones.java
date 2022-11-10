package controller;

import DTO.*;

import model.*;
import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones instancia;

    private static List<Peticiones> listaPeticiones;
    private static List<Resultado> listaResultados;
    public ArrayList<PeticionesDTO> listaPeticionesDTO;


    //SINGLETON
    public static ControllerPeticiones getInstancia() {
        if (instancia == null)
            instancia = new ControllerPeticiones();
        return instancia;
    }

    //CONSTRUCTOR
    public ControllerPeticiones() {
        listaPeticiones = new ArrayList<Peticiones>();
        listaResultados = new ArrayList<Resultado>();
        listaPeticionesDTO = new ArrayList<PeticionesDTO>();
    }

     //GETTER Y SETTERS
     public static List<Peticiones> getListaPeticiones() {
         return listaPeticiones;
     }
     public ArrayList<PeticionesDTO> getListaPeticionesDTO() { return listaPeticionesDTO; }

    public static void setListaPeticiones(List<Peticiones> listaPeticiones) {
        ControllerPeticiones.listaPeticiones = listaPeticiones;
    }

    public static List<Resultado> getListaResultados() {
        return listaResultados;
    }

    public static void setListaResultados(List<Resultado> listaResultados) {
        ControllerPeticiones.listaResultados = listaResultados;
    }


    //ABM RESULTADOS
    public void altaResultados(ResultadoDTO resultadoDTO) {
        Resultado resultado = new Resultado();
        listaResultados.add(resultado);
    }

    public void bajaResultados(ResultadoDTO resuBaja) {
        for (Resultado resultado: listaResultados) {
            if (resultado.getID() == resuBaja.ID)
                listaResultados.remove(resultado);
        }
    }

    public void modificacionResultado(ResultadoDTO resuMod) {
        for (Resultado resultado: listaResultados) {
            if (resultado.getID() == resuMod.ID)
            {
                resultado.setID(resuMod.ID);

            }
        }
    }


    //ABM PETICIONES
    public void altaPeticion(PeticionesDTO peticionesDTO) {
        Peticiones peticion = new Peticiones(peticionesDTO.paciente, peticionesDTO.sucursal, peticionesDTO.ObraSocial, peticionesDTO.fechaCarga , peticionesDTO.fechaEntrega, peticionesDTO.estado, peticionesDTO.nroPeticion);
        listaPeticiones.add(peticion);
        listaPeticionesDTO.add(peticionesDTO);
    }

    public void bajaPeticion(PeticionesDTO peticionBaja) {
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionBaja.nroPeticion)
                listaResultados.remove(peticion);
        }
    }

    public void modificacionPeticion(PeticionesDTO peticionMod) {
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionMod.nroPeticion)
            {
                peticion.setPaciente(peticionMod.paciente);
                peticion.setObraSocial(peticionMod.ObraSocial);
                peticion.setFechaEntrega(peticionMod.fechaEntrega);
                peticion.setFechaCarga(peticionMod.fechaCarga);
                peticion.setEstado(peticionMod.estado);
                peticion.setNroPeticion(peticionMod.nroPeticion);
                peticion.setSucursal(peticionMod.sucursal);
            }
        }
    }

    //DATOS PETICION
    public void datosPeticion(PeticionesDTO peticionMod) { //return o IMPRIMIR?
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionMod.nroPeticion)
            {
                TipoEstado estado= peticion.getEstado();
                String fechaCarga=peticion.getFechaCarga();
                peticion.getFechaEntrega();
                peticion.getNroPeticion();
                peticion.getPracticasAsociadas();
                peticion.getSucursal();
                peticion.getObraSocial();
                peticion.getPaciente();

            }
        }
    }



    //METODOS:








      ///
    public void consultarResultados() {

    }

    public void procesarMuestras() { //laborista

    }
/*
    BUSCAR PETICION
    LISTAR PETICION
    AGREGAR PETICION
    ELIMINAR PETICION

 */


}
