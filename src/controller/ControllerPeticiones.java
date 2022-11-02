package controller;

import DTO.PeticionesDTO;
import DTO.ResultadoDTO;
import model.Peticiones;
import model.Resultado;

import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones instancia;

    public static ControllerPeticiones getInstancia() {
        if (instancia == null)
            instancia = new ControllerPeticiones();
        return instancia;
    }

    private ControllerPeticiones() {

    }

    private static List<Peticiones> listaPeticiones;
    private static List<Resultado> listaResultados;

    public void procesarMuestras() {

    }

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

    public void consultarResultados() {

    }

    public void altaPeticion(PeticionesDTO peticionesDTO) {
        Peticiones peticion = new Peticiones(peticionesDTO.paciente, peticionesDTO.ObraSocial, peticionesDTO.fechaCarga,
                peticionesDTO.practicasAsociadas, peticionesDTO.fechaEntrega, peticionesDTO.estado, peticionesDTO.nroPeticion);
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
                peticion.setFechaCarga(peticionMod.fechaCarga);
                peticion.setFechaCarga(peticionMod.fechaCarga);
                peticion.setEstado(peticionMod.estado);
                peticion.setNroPeticion(peticionMod.nroPeticion);
            }
        }
    }

    public void listarPeticiones() {

    }
}
