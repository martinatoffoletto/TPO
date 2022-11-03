package vista;

import javax.swing.*;

public class FrmPracticas extends JInternalFrame {
    private JList list1;
    private JButton nuevaPrácticaButton;
    private JButton modificarPrácticaButton;
    private JButton eliminarPrácticaButton;
    private JPanel pnlPrincipal;

    public FrmPracticas() {
        super("Practicas");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
    }
}
