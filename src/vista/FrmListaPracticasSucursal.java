package vista;

import DTO.SucursalDTO;

import javax.swing.*;

public class FrmListaPracticasSucursal extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;

    public FrmListaPracticasSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

    }
}
