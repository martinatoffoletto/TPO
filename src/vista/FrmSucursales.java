package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSucursales extends JInternalFrame {

    private JPanel pnlPrincipal;
    private JList list1;
    private JButton nuevaSucursalButton;
    private JButton modificarSucursalButton;
    private JButton eliminarSucursalButton;

    public FrmSucursales(){
        super("Sucursales");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        nuevaSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaSucursal dialog = new FrmNuevaSucursal();
                dialog.setVisible(true);
            }
        });
        modificarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarSucursal dialog = new FrmModificarSucursal();
                dialog.setVisible(true);
            }
        });
        eliminarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmEliminarSucursal dialog = new FrmEliminarSucursal();
                dialog.setVisible(true);
            }
        });
    }
}
