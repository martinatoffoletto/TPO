package vista;

import DTO.PacienteDTO;
import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.util.ArrayList;

public class FrmListaPacientesSucursal extends JDialog{
    private JList list1;
    private JPanel pnlPrincipal;
    public FrmListaPacientesSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

    }
}