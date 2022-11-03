package vista;

import javax.swing.*;

public class FrmEliminarSucursal extends JDialog {
    private JComboBox comboBox1;
    private JButton aceptarButton;
    private JPanel pnlPrincipal;

    public FrmEliminarSucursal() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
