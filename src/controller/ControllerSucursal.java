package controller;

import DTO.*;
import model.Paciente;
import model.Peticiones;
import model.Sucursal;
import java.util.ArrayList;
import java.util.List;

import model.enums.TipoEstado;

public class ControllerSucursal {

    private ArrayList<Sucursal> listaSucursal;
    private ArrayList<Paciente> listaPacientes;
    public ArrayList<SucursalDTO> listaSucursalDTO;
    public ArrayList<PacienteDTO> listaPacienteDTO;
    private static ControllerSucursal instancia;

    //CONSTRUCTOR
    public ControllerSucursal() {
        listaPacientes = new ArrayList<Paciente>();
        listaSucursal = new ArrayList<Sucursal>();
        listaSucursalDTO = new ArrayList<SucursalDTO>();
        listaPacienteDTO = new ArrayList<PacienteDTO>();
    }

    //SINGLETON
    public static ControllerSucursal getInstancia() {
        if (instancia == null)
            instancia = new ControllerSucursal();
        return instancia;
    }

    //GETTER Y SETTER
    ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }


    public ArrayList<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public ArrayList<SucursalDTO> getListaSucursalDTO() {
        return listaSucursalDTO;
    }
    public ArrayList<PacienteDTO> getListaPacienteDTO() { return listaPacienteDTO; }

    //METODOS :

    //ALTA SUCURSAL
    public void altaSucursal(SucursalDTO sucursalDTO) {
        Sucursal sc= new Sucursal(sucursalDTO.numero,sucursalDTO.direccion,sucursalDTO.responsableTecnico);
        listaSucursal.add(sc);
        listaSucursalDTO.add(sucursalDTO);
    }

    //BAJA SUCURSAL
    public void bajaSucursal(SucursalDTO sucursalBaja, SucursalDTO sucursalDerivacion) { //1) REGLA NEGOCIO .ELIMINA SI NINGUN PACIENTE TIENE PETICIONES FINALIZADAS
        boolean NoTieneFinalizada =true;
        Sucursal sucuBaja = null, sucuDerivacion = null;

        for (Sucursal sucursal: listaSucursal) {
            if (sucursal.getNumero() == sucursalBaja.numero)
                sucuBaja = sucursal;
        }

        for (Sucursal sucursal: listaSucursal) {
            if (sucursal.getNumero() == sucursalDerivacion.numero)
                sucuDerivacion = sucursal;
        }

        for (Paciente p: sucuBaja.getListaPacientes()){
             NoTieneFinalizada= bajaPacienteRN(p);
             if (!NoTieneFinalizada){
                 break;
             }
        }
        if (NoTieneFinalizada){ //2) REGLA NEGOCIO, DERIVA PETICIONES
            for (Peticiones pet: sucuBaja.getListaPeticiones()){
                sucuDerivacion.agregarPeticion(pet);
            }
            listaSucursal.remove(sucuBaja);
            listaSucursalDTO.remove(sucursalBaja);
        }
    }

    //MODIFICACION SUCURSAL
    public void modificacionSucursal(SucursalDTO sucursalDTO) {
        for (SucursalDTO sucursalDTO1: listaSucursalDTO)
            if(sucursalDTO1.numero == sucursalDTO.numero) {
                sucursalDTO1.numero = sucursalDTO.numero;
                sucursalDTO1.direccion = sucursalDTO.direccion;
                sucursalDTO1.responsableTecnico = sucursalDTO.responsableTecnico;
            }
        for (Sucursal sucursal: listaSucursal){
            if(sucursal.getNumero()==sucursalDTO.numero){
                if(sucursalDTO.direccion!=null){
                    sucursal.setDireccion(sucursalDTO.direccion);
                }

                sucursal.setNumero(sucursalDTO.numero);
                sucursal.setResponsableTecnico(sucursalDTO.responsableTecnico);
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

    //LISTAR PETICIONES X SUCURSAL
    public void listarPeticionesSucursales(SucursalDTO sucursalDTO) {
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                List<Peticiones> listaPeticiones = sc.getListaPeticiones();
            }
        }

    }


    //DATOS SUCURSAL
    public void DatosSucursal(SucursalDTO sucursalDTO) { //DEVUELVE O IMPRIME?
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                int numero= sc.getNumero();
                String direccion= sc.getDireccion();
                String responsableTecnico =sc.getResponsableTecnico();
            }
        }

    }



    //ALTA PACIENTES
    public void altaPaciente(PacienteDTO pacienteDTO) {
        Paciente pc= new Paciente(pacienteDTO.DNI, pacienteDTO.nombre, pacienteDTO.domicilio, pacienteDTO.mail, pacienteDTO.sexo,pacienteDTO.edad);
        listaPacientes.add(pc);
        listaPacienteDTO.add(pacienteDTO);

    }

    //BAJA PACIENTES
    public boolean bajaPacienteRN(Paciente paciente1) { // 1) CON REGLA DE NEGOCIO 1 (no puede tener peticiones finalizadas)
        for (Paciente paciente: listaPacientes){
            if (paciente.getDNI()==paciente1.getDNI()){
                for (Peticiones peticiones: ControllerPeticiones.getListaPeticiones()){
                    if (peticiones.getPaciente()==paciente){
                        if (peticiones.getEstado()== TipoEstado.Con_Resultados){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public void bajaPaciente(PacienteDTO pacienteDTO){  //Elimina paciente
        Paciente pacBaja = null;
        for (Paciente paciente: listaPacientes) {
            if (paciente.getDNI() == pacienteDTO.DNI)
                pacBaja = paciente;
        }
        boolean NotieneFinalizas= bajaPacienteRN(pacBaja);
        if (NotieneFinalizas){
            for (Paciente pac: listaPacientes){
                if (pac.getDNI()==pacienteDTO.DNI){
                    listaPacientes.remove(pac);
                }
            }
        }
    }

    //MODIFICACION PACIENTES
    public void modificacionPaciente(PacienteDTO pacienteDTO) {
        for(PacienteDTO pacienteDTO1: listaPacienteDTO)
            if (pacienteDTO1.DNI == pacienteDTO.DNI) {
                pacienteDTO1.DNI = pacienteDTO.DNI;
                pacienteDTO1.domicilio = pacienteDTO.domicilio;
                pacienteDTO1.mail = pacienteDTO.mail;
                pacienteDTO1.sexo = pacienteDTO.sexo;
                pacienteDTO1.nombre = pacienteDTO.nombre;
            }
        for (Paciente paciente: listaPacientes) {
            if (paciente.getDNI() == pacienteDTO.DNI) {
                paciente.setDNI(pacienteDTO.DNI);
                paciente.setDomicilio(pacienteDTO.domicilio);
                paciente.setMail(pacienteDTO.mail);
                paciente.setSexo(pacienteDTO.sexo);
                paciente.setNombre(pacienteDTO.nombre);

            }
        }
    }



    //Listar Peticiones PACIENTE
    public void peticionesPaciente(PacienteDTO pacienteDTO) {
        for (Paciente paciente: listaPacientes){
            if (paciente.getDNI()==pacienteDTO.DNI){
                paciente.getListaPeticionesPaciente();
            }
        }


    }

    //DATOS PACIENTE

    public void DatosPaciente(PacienteDTO pacienteDTO){
        for (Paciente paciente: listaPacientes){
            if (paciente.getDNI()==pacienteDTO.DNI){
                int dni=paciente.getDNI();
                String nombre= paciente.getNombre();
                String sexo  =paciente.getSexo();
                String mail= paciente.getMail();
                String domicilio=paciente.getDomicilio();

            }
        }
    }









      /*
        //AGREGAR PRACTICA EN SUCURSAL

    public void AgregarPractica(Sucursal sucursal, Practicas prac){
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursal.getNumero()){
                sc.agregarPractica(prac);
            }
        }
    }

    //Agregar Paciente en SUCURSAL
    public void AgregarPaciente(SucursalDTO sucursalDTO, PacienteDTO pacienteDTO){
        Paciente paciente1 = null;
        for (Paciente paciente: listaPacientes)
            if (paciente.getDNI() == pacienteDTO.DNI)
                paciente1 = paciente;
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                sc.agregarPaciente(paciente1);
            }
        }
    }

       */






}
