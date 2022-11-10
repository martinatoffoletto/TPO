package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPacientes extends JInternalFrame {
    private JList list1;
    private JButton nuevoPacienteButton;
    private JButton modificarPacienteButton;
    private JButton eliminarPacienteButton;
    private JPanel pnlPrincipal;
    private JButton listarPeticionesButton;

    public FrmPacientes() {
        super("Pacientes");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        nuevoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoPaciente dialog = new FrmNuevoPaciente();
                dialog.setVisible(true);
            }
        });
        modificarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPaciente dialog = new FrmModificarPaciente();
                dialog.setVisible(true);
            }
        });
        eliminarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
