package vista;

import javax.swing.*;

public class FrmReglas extends JInternalFrame {
    private JPanel pnlPrincipal;

    public FrmReglas() {
        super("Reglas");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
    }
}
