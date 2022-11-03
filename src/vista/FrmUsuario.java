package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmUsuario extends JInternalFrame {
    private JList list1;
    private JPanel pnlPrincipal;
    private JButton nuevoUsuarioButton;
    private JButton modificarUsuarioButton;
    private JButton eliminarUsuarioButton;

    public FrmUsuario() {
        super("Usuarios");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoUsuario dialog = new FrmNuevoUsuario();
                dialog.setVisible(true);
            }
        });
        modificarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarUsuario dialog = new FrmModificarUsuario();
                dialog.setVisible(true);
            }
        });
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
