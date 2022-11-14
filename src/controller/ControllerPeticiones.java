package controller;

import DTO.*;

import model.*;
import model.enums.TipoEstado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones instancia;

    private  ArrayList<Peticiones> listaPeticiones;
    private  ArrayList<Resultado> listaResultados;
    public ArrayList<PeticionesDTO> listaPeticionesDTO;
    public ArrayList<ResultadoDTO> listaResultadosDTO;


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
        listaResultadosDTO = new ArrayList<ResultadoDTO>();
    }

     //GETTER Y SETTERS
     public ArrayList<Peticiones> getListaPeticiones() {
         return listaPeticiones;
     }
     public ArrayList<PeticionesDTO> getListaPeticionesDTO() {
        return listaPeticionesDTO;
     }


    public ArrayList<Resultado> getListaResultados() {
        return listaResultados;
    }


    //ABM RESULTADOS
    public void altaResultados(ResultadoDTO resultadoDTO) {
        Resultado resultado = new Resultado(resultadoDTO.ID, resultadoDTO.valorNumerico, resultadoDTO.valorBooleano, resultadoDTO.descripcion);
        listaResultados.add(resultado);
        listaResultadosDTO.add(resultadoDTO);
    }

    public void bajaResultados(ResultadoDTO resuBaja) {
        for (Resultado resultado: listaResultados) {
            if (resultado.getID() == resuBaja.ID) {
                listaResultados.remove(resultado);
                listaResultadosDTO.remove(resuBaja);
            }

        }
    }

    public void modificacionResultado(ResultadoDTO resuMod) {
        for (ResultadoDTO resultadoDTO: listaResultadosDTO)
            if (resultadoDTO.ID==resuMod.ID) {
                resultadoDTO.ID=resuMod.ID;
                resultadoDTO.valorNumerico= resuMod.valorNumerico;
                resultadoDTO.valorBooleano= resuMod.valorBooleano;
                resultadoDTO.descripcion= resuMod.descripcion;
            }
        for (Resultado resultado: listaResultados) {
            if (resultado.getID() == resuMod.ID)
            {
                resultado.setID(resuMod.ID);
                resultado.setValorNumerico(resuMod.valorNumerico);
                resultado.setValorBooleano(resuMod.valorBooleano);
                resultado.setDescripcion(resuMod.descripcion);

            }
        }
    }


    //ABM PETICIONES
    public void altaPeticion(PeticionesDTO peticionesDTO) {
        Peticiones peticion = new Peticiones(peticionesDTO.paciente, peticionesDTO.ObraSocial, peticionesDTO.fechaCarga , peticionesDTO.fechaEntrega, peticionesDTO.estado, peticionesDTO.nroPeticion,peticionesDTO.sucursal);
        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente == peticionesDTO.paciente)
                paciente.AgregarPeticion(peticion);
        listaPeticiones.add(peticion);
        listaPeticionesDTO.add(peticionesDTO);
    }

    public void bajaPeticion(PeticionesDTO peticionBaja) {
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionBaja.nroPeticion) {
                listaPeticiones.remove(peticion);
                listaPeticionesDTO.remove(peticionBaja);
                for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
                    if (paciente == peticionBaja.paciente)
                        paciente.listaPeticionesPaciente.remove(peticion);
            }
        }
    }

    public void modificacionPeticion(PeticionesDTO peticionMod) {
        for (PeticionesDTO peticionesDTO: listaPeticionesDTO)
            if (peticionesDTO.nroPeticion==peticionMod.nroPeticion) {
                peticionesDTO.nroPeticion=peticionMod.nroPeticion;
                peticionesDTO.paciente=peticionMod.paciente;
                peticionesDTO.sucursal=peticionMod.sucursal;
                peticionesDTO.estado=peticionMod.estado;
                peticionesDTO.ObraSocial=peticionMod.ObraSocial;
                peticionesDTO.fechaCarga=peticionMod.fechaCarga;
                peticionesDTO.fechaEntrega=peticionMod.fechaEntrega;
            }
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionMod.nroPeticion) {
                peticion.setPaciente(peticionMod.paciente);
                peticion.setObraSocial(peticionMod.ObraSocial);
                peticion.setFechaEntrega(peticionMod.fechaEntrega);
                peticion.setFechaCarga(peticionMod.fechaCarga);
                peticion.setEstado(peticionMod.estado);
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
