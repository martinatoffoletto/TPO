package vista;

import DTO.SucursalDTO;

import javax.swing.*;

public class FrmListaPeticionesSucursal extends JDialog {

    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListaPeticionesSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

    }
}
