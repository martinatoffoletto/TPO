package controller;

import DTO.*;
import model.Paciente;
import model.Peticiones;
import model.Practicas;
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

        for (Peticiones peticion: sucuBaja.getListaPeticiones())
            if (peticion.getEstado().equals(TipoEstado.Con_Resultados)) {
                NoTieneFinalizada = false;
                break;
            }

        if (NoTieneFinalizada){ //2) REGLA NEGOCIO, DERIVA PETICIONES
            for (Peticiones pet: sucuBaja.getListaPeticiones()){
                pet.setSucursal(sucuDerivacion);
                sucuDerivacion.agregarPeticion(pet);
                sucuDerivacion.agregarPaciente(pet.getPaciente());
                for (Peticiones peticion: ControllerPeticiones.getInstancia().getListaPeticiones())
                    if (peticion.getNroPeticion() == pet.getNroPeticion()) {
                        peticion.setSucursal(sucuDerivacion);
                    }
                for (PeticionesDTO peticionDTO: ControllerPeticiones.getInstancia().listaPeticionesDTO)
                    if (peticionDTO.nroPeticion == pet.getNroPeticion())
                        peticionDTO.sucursal = sucursalDerivacion;
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
    public ArrayList<PacienteDTO> listarPacientesSucursales(SucursalDTO sucursalDTO) {
        ArrayList <Paciente> listaPacientesSucursal = new ArrayList<Paciente>();
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                listaPacientesSucursal = sc.getListaPacientes();
            }
        }
        ArrayList<PacienteDTO> listaPacientesSucursalDTO = new ArrayList<PacienteDTO>();
        for (Paciente pc: listaPacientesSucursal)
            for (PacienteDTO pcDTO: listaPacienteDTO)
                if (pc.getDNI() == pcDTO.DNI)
                    listaPacientesSucursalDTO.add(pcDTO);

        return listaPacientesSucursalDTO;
    }

    //LISTAR PETICIONES X SUCURSAL
    public ArrayList<PeticionesDTO> listarPeticionesSucursales(SucursalDTO sucursalDTO) {
        ArrayList<Peticiones> listaPeticionesSucursal = new ArrayList<Peticiones>();
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursalDTO.numero){
                listaPeticionesSucursal = sc.getListaPeticiones();
            }
        }
        ArrayList<PeticionesDTO> listaPeticionesSucursalDTO = new ArrayList<PeticionesDTO>();
        for (Peticiones peticion: listaPeticionesSucursal)
            for (PeticionesDTO peticionDTO: ControllerPeticiones.getInstancia().listaPeticionesDTO)
                if (peticion.getNroPeticion() == peticionDTO.nroPeticion)
                    listaPeticionesSucursalDTO.add(peticionDTO);
        return listaPeticionesSucursalDTO;
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

    public void bajaPaciente(PacienteDTO pacienteDTO){  //Elimina paciente
        Paciente pacBaja = null;
        for (Paciente paciente: listaPacientes) {
            if (paciente.getDNI() == pacienteDTO.DNI)
                pacBaja = paciente;
        }
        boolean NoTieneFinalizadas = true;
        for (Peticiones peticion: pacBaja.getListaPeticionesPaciente())
            if (peticion.getEstado() == TipoEstado.Con_Resultados) {
                NoTieneFinalizadas = false;
                break;
            }
        if (NoTieneFinalizadas) {
            listaPacientes.remove(pacBaja);
            listaPacienteDTO.remove(pacienteDTO);
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
    public ArrayList<PeticionesDTO> listarPeticionesPaciente(PacienteDTO pacienteDTO) {
        ArrayList<Peticiones> listaPeticionesPaciente = new ArrayList<Peticiones>();
        for (Paciente paciente: listaPacientes){
            if (paciente.getDNI()==pacienteDTO.DNI){
                listaPeticionesPaciente = paciente.getListaPeticionesPaciente();
            }
        }
        ArrayList<PeticionesDTO> listaPeticionesPacienteDTO = new ArrayList<PeticionesDTO>();
        for (PeticionesDTO peticionDTO: ControllerPeticiones.getInstancia().listaPeticionesDTO)
            for (Peticiones peticion: listaPeticionesPaciente)
                if (peticionDTO.nroPeticion == peticion.getNroPeticion())
                    listaPeticionesPacienteDTO.add(peticionDTO);

    return listaPeticionesPacienteDTO;
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










        //AGREGAR PRACTICA EN SUCURSAL

    public void AgregarPracticaSucursal(SucursalDTO sucursal, PracticasDTO prac){
        for (Sucursal sc:listaSucursal){
            if (sc.getNumero()==sucursal.numero){
                for (Practicas practica: ControllerParametros.getInstancia().getListaPracticas())
                    if (practica.getCodigo() == prac.codigo)
                        sc.agregarPractica(practica);
            }
        }
    }

    public ArrayList<PracticasDTO> listarPracticasSucursal(SucursalDTO sucursalDTO) {
        ArrayList<Practicas> listaPracticasSucursal = new ArrayList<Practicas>();
        for (Sucursal sucursal: listaSucursal)
            if (sucursal.getNumero() == sucursalDTO.numero) {
                listaPracticasSucursal = sucursal.getListaPracticas();
            }
        ArrayList<PracticasDTO> listaPracticasSucursalDTO = new ArrayList<PracticasDTO>();
        for (Practicas practica: listaPracticasSucursal)
            for (PracticasDTO practicasDTO: ControllerParametros.getInstancia().listaPracticasDTO)
                if (practica.getCodigo() == practicasDTO.codigo)
                    listaPracticasSucursalDTO.add(practicasDTO);
        return listaPracticasSucursalDTO;
    }
/*
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
