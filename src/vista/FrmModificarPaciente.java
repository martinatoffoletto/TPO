package vista;

import javax.swing.*;

public class FrmModificarPaciente extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femeninoRadioButton;
    private JTextField textField5;
    private JTextField textField6;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmModificarPaciente() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
