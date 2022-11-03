package vista;

import javax.swing.*;

public class FrmModificarPeticion extends JDialog {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmModificarPeticion() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
