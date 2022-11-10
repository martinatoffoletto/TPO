package controller;
import DTO.*;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones instancia;

    private static List<Peticiones> listaPeticiones;
    private static List<Resultado> listaResultados;


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
    }

     //GETTER Y SETTERS
     public static List<Peticiones> getListaPeticiones() {
         return listaPeticiones;
     }

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
    public void altaPeticion(PeticionesDTO peticionesDTO) { //RETURN
        Peticiones peticion = new Peticiones(peticionesDTO.paciente, peticionesDTO.ObraSocial, peticionesDTO.fechaCarga , peticionesDTO.fechaEntrega, peticionesDTO.estado, peticionesDTO.nroPeticion,peticionesDTO.sucursal);
        listaPeticiones.add(peticion);
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
    public void datosPeticion(PeticionesDTO peticionMod) {
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionMod.nroPeticion)
            {
                peticion.getEstado();
                peticion.getFechaCarga();
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
