package vista;

import javax.swing.*;

public class FrmPeticiones extends JInternalFrame{
    private JList list1;
    private JButton nuevaPeticiónButton;
    private JButton modificarPeticiónButton;
    private JButton eliminarPeticiónButton;
    private JPanel pnlPrincipal;

    public FrmPeticiones() {
        super("Peticiones");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
    }
}
