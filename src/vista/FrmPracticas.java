package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPracticas extends JInternalFrame {
    private JList list1;
    private JButton nuevaPracticaButton;
    private JButton modificarPracticaButton;
    private JButton eliminarPracticaButton;
    private JPanel pnlPrincipal;

    public FrmPracticas() {
        super("Practicas");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        nuevaPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaPractica dialog = new FrmNuevaPractica();
                dialog.setVisible(true);
            }
        });
        modificarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPractica dialog = new FrmModificarPractica();
                dialog.setVisible(true);
            }
        });
        eliminarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
