package vista;

import javax.swing.*;

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
    }
}
