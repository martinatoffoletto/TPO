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
    private JButton reglasButton;

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
        pacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPacientes pantalla = new FrmPacientes();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
        practicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPracticas pantalla = new FrmPracticas();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
        peticionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPeticiones pantalla = new FrmPeticiones();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmUsuario pantalla = new FrmUsuario();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
        reglasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmReglas pantalla = new FrmReglas();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
    }
}
