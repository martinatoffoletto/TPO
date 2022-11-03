package controller;

import DTO.PacienteDTO;
import DTO.SucursalDTO;
import model.Paciente;
import model.Peticiones;
import model.Practicas;
import model.Sucursal;
import java.util.ArrayList;
import java.util.List;
import controller.*;
import model.enums.TipoEstado;

public class ControllerSucursal {

    private List<Sucursal> listaSucursal;
    private List<Paciente> listaPacientes;
    private static ControllerSucursal instancia;


    //CONSTRUCTOR
    public ControllerSucursal() {
        listaPacientes = new ArrayList<Paciente>();
        listaSucursal = new ArrayList<Sucursal>();
    }

    //SINGLETON
    public static ControllerSucursal getInstancia() {
        if (instancia == null)
            instancia = new ControllerSucursal();
        return instancia;
    }

    //GETTER Y SETTER
    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(List<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }


    //METODOS:


    //ABM SUCURSAL
    public void altaSucursal(SucursalDTO sucursalDTO) {
        Sucursal sc= new Sucursal(sucursalDTO.numero,sucursalDTO.direccion,sucursalDTO.responsableTecnico,sucursalDTO.listaPeticiones,sucursalDTO.listaPractica,sucursalDTO.listaPacientes);
        listaSucursal.add(sc);
    }

    public void bajaSucursal(Sucursal sucursals) { //1) REGLA NEGOCIO .ELIMINA SI NINGUN PACIENTE TIENE PETICIONES FINALIZADAS
        boolean NoTieneFinalizada =true;
        for (Sucursal sucursal: listaSucursal) {
            if (sucursal.getNumero() == sucursals.getNumero()) {
                for (Paciente p: sucursals.getListaPacientes()){
                     NoTieneFinalizada= bajaPacienteRN(p);
                     if (!NoTieneFinalizada){
                         break;
                     }
                }
            }
        }
        if (NoTieneFinalizada){ //2) REGLA NEGOCIO, DERIVA PETICIONES
            for (Peticiones pet: ControllerPeticiones.getListaPeticiones()){
                if (pet.getSucursal()==sucursals){
                    derivarPeticion(pet);
                }
            }
            listaSucursal.remove(sucursals);



        }
    }
    public void derivarPeticion(Peticiones peticiones) { //Incompleto
        List<Sucursal> sucursalesDisponibles= ControllerPeticiones.getInstancia().ListarPeticionSucursal(peticiones);
        Sucursal sc=sucursalesDisponibles.get(0);
        sc.agregarPeticion(peticiones);


    }


    public void modificacionSucursal(SucursalDTO sucursalDTO) {
        for (Sucursal sucursal: listaSucursal){
            if(sucursal.getNumero()==sucursalDTO.numero){
                sucursal.setDireccion(sucursalDTO.direccion);
                sucursal.setNumero(sucursalDTO.numero);
                sucursal.setResponsableTecnico(sucursalDTO.responsableTecnico);
                sucursal.setListaPacientes(sucursalDTO.listaPacientes);
                sucursal.setListaPeticiones(sucursalDTO.listaPeticiones);
                sucursal.setListaPractica(sucursalDTO.listaPractica);
            }
        }

    }





    //ABM PACIENTES
    public void altaPaciente(PacienteDTO pacienteDTO) {
        Paciente pc= new Paciente(pacienteDTO.DNI, pacienteDTO.nombre, pacienteDTO.domicilio, pacienteDTO.mail, pacienteDTO.sexo,pacienteDTO.edad);
        listaPacientes.add(pc);

    }

    public boolean bajaPacienteRN(Paciente pacientes) { // 1) CON REGLA DE NEGOCIO 1 (no puede tener peticiones finalizadas)
        for (Paciente paciente: listaPacientes){
            if (paciente.getDNI()==pacientes.getDNI()){
                for (Peticiones peticiones: ControllerPeticiones.getListaPeticiones()){
                    if (peticiones.getPaciente()==pacientes){
                        if (peticiones.getEstado()== TipoEstado.Con_Resultados){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void bajaPaciente(Paciente paciente){  //Elimina paciente
        boolean NotieneFinalizas= bajaPacienteRN(paciente);
        if (NotieneFinalizas){
            for (Paciente pac: listaPacientes){
                if (pac.getDNI()==paciente.getDNI()){
                    listaPacientes.remove(pac);
                }
            }
        }
    }

    public void modificacionPaciente(PacienteDTO pacienteDTO) {
        for (Paciente paciente: listaPacientes){
            if (paciente.getDNI()==pacienteDTO.DNI){
                paciente.setDNI(pacienteDTO.DNI);
                paciente.setEdad(pacienteDTO.edad);
                paciente.setDomicilio(pacienteDTO.domicilio);
                paciente.setMail(pacienteDTO.mail);
                paciente.setSexo(pacienteDTO.sexo);
                paciente.setNombre(pacienteDTO.nombre);

            }
        }

    }






   //LISTAR PACIENTE X SUCURSAL
    public void listarPacientesSucursales(SucursalDTO sucursalDTO) {
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                sc.getListaPacientes();
            }
        }

    }

    //LISTAR PRACTICAS X SUCURSAL
    public void listarPracticasSucursales(SucursalDTO sucursalDTO) {
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                sc.getListaPractica();
            }
        }

    }

    //AGREGAR PRACTICA EN SUCURSAL

    public void AgregarPractica(Sucursal sucursal, Practicas prac){
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursal.getNumero()){
                sc.agregarPractica(prac);
            }
        }
    }

    //Agregar Paciente en SUCURSAL
    public void AgregarPaciente(Sucursal sucursal,Paciente p){
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursal.getNumero()){
                sc.agregarPaciente(p);
            }
        }
    }






}
