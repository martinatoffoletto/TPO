package vistas;

import javax.swing.*;

public class FrmMenuPrincipal extends JFrame {
    private JPanel pnlPrincipal;
    private JButton pacientesButton;
    private JButton peticionesButton;
    private JButton resultadosButton;

    public FrmMenuPrincipal() {
        super("Menu Principal");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }


}
