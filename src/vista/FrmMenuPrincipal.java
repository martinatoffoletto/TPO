package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuPrincipal extends JFrame {
    private JPanel pnlPrincipal;
    private JButton pacientesButton;
    private JButton practicasButton;
    private JButton sucursalesButton;
    private JButton peticionesButton;
    private JButton usuariosButton;
    private JDesktopPane desktopPaneEmbebido;

    public FrmMenuPrincipal() {
        super("Menu Principal");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

        sucursalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSucursales pantalla = new FrmSucursales();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
    }
}
