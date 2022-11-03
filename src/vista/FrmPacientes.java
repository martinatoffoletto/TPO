package vista;

import javax.swing.*;

public class FrmPacientes extends JInternalFrame {
    private JList list1;
    private JButton nuevoPacienteButton;
    private JButton modificarPacienteButton;
    private JButton eliminarPacienteButton;
    private JPanel pnlPrincipal;

    public FrmPacientes() {
        super("Pacientes");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
    }
}
