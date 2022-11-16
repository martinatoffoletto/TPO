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

    public ArrayList<ResultadoDTO> getListaResultadosDTO() {
        return listaResultadosDTO;
    }

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
        Peticiones peticion = null;
        PeticionesDTO peticionDTO = null;
        for (Peticiones peticiones: listaPeticiones)
            if (peticiones.getNroPeticion() == resultadoDTO.peticion.nroPeticion)
                peticion = peticiones;
        Resultado resultado = new Resultado(resultadoDTO.ID, resultadoDTO.valorNumerico, resultadoDTO.valorBooleano, peticion);
        listaResultados.add(resultado);
        listaResultadosDTO.add(resultadoDTO);
        peticion.setResultado(resultado);
        for (PeticionesDTO peticionesDTO: listaPeticionesDTO)
            if (peticionesDTO.nroPeticion == peticion.getNroPeticion())
                peticionDTO = peticionesDTO;
        peticionDTO.resultadoDTO = resultadoDTO;

        peticionDTO.estado = TipoEstado.Con_Resultados;
        modificacionPeticion(peticionDTO);
    }

    public void bajaResultados(ResultadoDTO resultadoDTO) {
        Resultado resuBaja = null;
        for (Resultado resultado: listaResultados)
            if (resultado.getID() == resultadoDTO.ID) {
                resuBaja = resultado;
            }
        listaResultados.remove(resuBaja);
        listaResultadosDTO.remove(resultadoDTO);

    }

    public void modificacionResultado(ResultadoDTO resuMod) {
        for (ResultadoDTO resultadoDTO: listaResultadosDTO)
            if (resultadoDTO.ID==resuMod.ID) {
                resultadoDTO.ID=resuMod.ID;
                resultadoDTO.valorNumerico= resuMod.valorNumerico;
                resultadoDTO.valorBooleano= resuMod.valorBooleano;
                resultadoDTO.peticion= resuMod.peticion;
            }
        for (Resultado resultado: listaResultados) {
            if (resultado.getID() == resuMod.ID)
            {
                resultado.setID(resuMod.ID);
                resultado.setValorNumerico(resuMod.valorNumerico);
                resultado.setValorBooleano(resuMod.valorBooleano);
            }
        }
    }


    //ABM PETICIONES
    public void altaPeticion(PeticionesDTO peticionesDTO) {
        Paciente pacientePeticion = null;
        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente.getDNI() == peticionesDTO.paciente.DNI)
                pacientePeticion = paciente;
        Sucursal sucursalPeticion = null;
        for (Sucursal sucursal: ControllerSucursal.getInstancia().getListaSucursal())
            if (sucursal.getNumero() == peticionesDTO.sucursal.numero)
                sucursalPeticion = sucursal;
        Practicas practicaAsociada = null;
        for (Practicas practica: ControllerParametros.getInstancia().getListaPracticas())
            if (practica.getCodigo() == peticionesDTO.practicaAsociada.codigo)
                practicaAsociada = practica;
        Peticiones peticion = new Peticiones(pacientePeticion, sucursalPeticion,practicaAsociada, peticionesDTO.ObraSocial, peticionesDTO.fechaCarga , peticionesDTO.fechaEntrega, peticionesDTO.estado, peticionesDTO.nroPeticion);
        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente.getDNI() == peticionesDTO.paciente.DNI)
                paciente.AgregarPeticion(peticion);
        for (Sucursal sucursal: ControllerSucursal.getInstancia().getListaSucursal())
            if (sucursal.getNumero() == peticionesDTO.sucursal.numero) {
                sucursal.agregarPeticion(peticion);
                sucursal.agregarPaciente(peticion.getPaciente());
            }
        listaPeticiones.add(peticion);
        listaPeticionesDTO.add(peticionesDTO);
    }

    public void bajaPeticion(PeticionesDTO peticionBaja) {
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionBaja.nroPeticion) {
                listaPeticiones.remove(peticion);
                listaPeticionesDTO.remove(peticionBaja);
                for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
                    if (paciente.getDNI() == peticionBaja.paciente.DNI)
                        paciente.listaPeticionesPaciente.remove(peticion);
            }
        }
    }

    public void modificacionPeticion(PeticionesDTO peticionMod) {
        for (PeticionesDTO peticionesDTO: listaPeticionesDTO)
            if (peticionesDTO.nroPeticion==peticionMod.nroPeticion) {
                peticionesDTO.paciente=peticionMod.paciente;
                peticionesDTO.sucursal=peticionMod.sucursal;
                peticionesDTO.estado=peticionMod.estado;
                peticionesDTO.ObraSocial=peticionMod.ObraSocial;
                peticionesDTO.fechaCarga=peticionMod.fechaCarga;
                peticionesDTO.fechaEntrega=peticionMod.fechaEntrega;
                peticionesDTO.practicaAsociada=peticionMod.practicaAsociada;
            }
        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionMod.nroPeticion) {
                peticion.setObraSocial(peticionMod.ObraSocial);
                peticion.setFechaEntrega(peticionMod.fechaEntrega);
                peticion.setFechaCarga(peticionMod.fechaCarga);
                peticion.setEstado(peticionMod.estado);
                for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
                    if (paciente.getDNI() == peticionMod.paciente.DNI)
                        peticion.setPaciente(paciente);
                for (Sucursal sucursal: ControllerSucursal.getInstancia().getListaSucursal())
                    if (sucursal.getNumero() == peticionMod.sucursal.numero)
                        peticion.setSucursal(sucursal);
                for (Practicas practica: ControllerParametros.getInstancia().getListaPracticas())
                    if (practica.getCodigo() == peticionMod.practicaAsociada.codigo)
                        peticion.setPracticaAsociada(practica);
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
                peticion.getPracticaAsociada();
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
