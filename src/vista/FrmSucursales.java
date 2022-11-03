package vista;

import javax.swing.*;

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
    }
}
