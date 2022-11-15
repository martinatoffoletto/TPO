package vista;

import DTO.PacienteDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;
import model.Paciente;
import model.Peticiones;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListarPeticionesPaciente extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;
    private JCheckBox listarEnValoresCriticosCheckBox;

    public FrmListarPeticionesPaciente(PacienteDTO pacienteDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista(pacienteDTO);
    }

    public void asignarDatosLista(PacienteDTO pacienteDTO) {
        ArrayList<Peticiones> listaPeticiones = ControllerSucursal.getInstancia().listarPeticionesPaciente(pacienteDTO);
        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPeticiones);
        list1.setModel(model);
    }
}
