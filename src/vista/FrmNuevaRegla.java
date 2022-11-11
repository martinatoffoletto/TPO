package vista;

import javax.swing.*;

public class FrmNuevaRegla extends JDialog {
    private JPanel pnlPrincipal;

    public FrmNuevaRegla() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
