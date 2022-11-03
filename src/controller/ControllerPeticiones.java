package controller;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.ResultadoDTO;
import model.Peticiones;
import model.Resultado;
import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ControllerPeticiones {

    private static ControllerPeticiones instancia;

    public static ControllerPeticiones getInstancia() {
        if (instancia == null)
            instancia = new ControllerPeticiones();
        return instancia;
    }

    private ControllerPeticiones() {
        listaPeticiones = new ArrayList<Peticiones>();
        listaResultados = new ArrayList<Resultado>();

        listaPaciente = new ArrayList<Paciente>();

    }

    public int agregarPaciente(int sucursal, PacienteDTO p)
    {
        Paciente unPaciente = new Paciente(p.DNI, p.nombre, p.domicilio, p.mail, p.sexo, p.edad);
        listaPaciente.add(unPaciente);

        ControllerSucursal.getInstancia().agregarPacienteSucursal(sucursal, unPaciente);
return listaPaciente.size();
    }

    private static List<Peticiones> listaPeticiones;
    private static List<Resultado> listaResultados;

    private static List<Paciente> listaPaciente;

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
