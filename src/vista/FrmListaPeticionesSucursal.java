package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.SucursalDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListaPeticionesSucursal extends JDialog {

    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListaPeticionesSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosLista(sucursalDTO);

    }

    public void asignarDatosLista(SucursalDTO sucursalDTO) {
        ArrayList<PeticionesDTO> listaPeticiones = ControllerSucursal.getInstancia().listarPeticionesSucursales(sucursalDTO);
        DefaultListModel model = new DefaultListModel();
        model.addAll(listaPeticiones);
        list1.setModel(model);
    }
}
