package vista;

import javax.swing.*;

public class FrmModificarSucursal extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmModificarSucursal() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
