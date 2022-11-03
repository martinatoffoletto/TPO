package controller;

import model.Paciente;
import model.Sucursal;

import java.util.List;

public class ControllerSucursal {

    private List<Sucursal> listaSucursal;
    private List<Paciente> lisaPacientes;
    private static ControllerSucursal instancia;

    public static ControllerSucursal getInstancia() {
        if (instancia == null)
            instancia = new ControllerSucursal();
        return instancia;
    }
    int agregarPacienteSucursal(int sucursal, Paciente unPaciente)
    {
        for (Sucursal s: listaSucursal) {
            if (s.getNumero() == sucursal)
                return s.agregarPaciente(unPaciente);
        }
        return -1;
    }

    public void listarPacientesSucursales() {

    }

    public void altaPaciente() {

    }

    public void bajaPaciente(int DNI) {

    }

    public void modificacionPaciente(int DNI) {

    }

    public void derivarPeticiones() {

    }
}
