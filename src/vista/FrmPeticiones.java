package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPeticiones extends JInternalFrame{
    private JList list1;
    private JButton nuevaPeticionButton;
    private JButton modificarPeticionButton;
    private JButton eliminarPeticionButton;
    private JPanel pnlPrincipal;
    private JButton datosPeticionButton;

    public FrmPeticiones() {
        super("Peticiones");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        nuevaPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaPeticion dialog = new FrmNuevaPeticion();
                dialog.setVisible(true);
            }
        });
        modificarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPeticion dialog = new FrmModificarPeticion();
                dialog.setVisible(true);
            }
        });
        eliminarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
