package vista;

import DTO.PacienteDTO;
import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerParametros;
import controller.ControllerSucursal;
import model.Practicas;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListaPracticasSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListaPracticasSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista(sucursalDTO);

    }

    public void asignarDatosLista(SucursalDTO sucursalDTO) {
        ArrayList<PracticasDTO> listaPracticas = ControllerSucursal.getInstancia().listarPracticasSucursal(sucursalDTO);
        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPracticas);
        list1.setModel(model);
    }
}
