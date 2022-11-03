package vista;

import javax.swing.*;

public class FrmNuevoUsuario extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmNuevoUsuario() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
