package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuPrincipal extends JFrame {
    private JPanel pnlPrincipal;
    private JButton button2;
    private JButton button3;
    private JButton controladorDeParametrosButton;
    private JDesktopPane desktopPaneEmbebido;

    public FrmMenuPrincipal() {
        super("Menu Principal");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asociarEventos();

    }
    private void asociarEventos() {
        controladorDeParametrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmControllerParametros pantalla = new FrmControllerParametros();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
    }

}
