package vista;

import javax.swing.*;

public class FrmModificarUsuario extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmModificarUsuario() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
