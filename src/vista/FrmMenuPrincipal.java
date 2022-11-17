package vista;

import DTO.UsuarioSistemaDTO;
import model.enums.TipoRol;

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
    private JButton resultadosButton;
    private JButton cerrarSesionButton;

    public FrmMenuPrincipal(UsuarioSistemaDTO usuarioSistemaDTO) {
        super("Menu Principal");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        if (usuarioSistemaDTO.rol == TipoRol.RECEPCIONISTA) {
            sucursalesButton.setVisible(false);
            practicasButton.setVisible(false);
            usuariosButton.setVisible(false);
            reglasButton.setVisible(false);
            resultadosButton.setVisible(false);
        } else if (usuarioSistemaDTO.rol == TipoRol.LABORATORISTA) {
            sucursalesButton.setVisible(false);
            pacientesButton.setVisible(false);
            practicasButton.setVisible(false);
            usuariosButton.setVisible(false);
            peticionesButton.setVisible(false);
            reglasButton.setVisible(false);

        }
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
                FrmPacientes pantalla = new FrmPacientes(usuarioSistemaDTO);
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
                FrmPeticiones pantalla = new FrmPeticiones(usuarioSistemaDTO);
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
        resultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmResultado pantalla = new FrmResultado(usuarioSistemaDTO);
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FrmLogin login = new FrmLogin();
                login.setVisible(true);
            }
        });
    }
}
