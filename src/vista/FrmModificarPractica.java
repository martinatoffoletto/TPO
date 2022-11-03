package vista;

import javax.swing.*;

public class FrmModificarPractica extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmModificarPractica() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
