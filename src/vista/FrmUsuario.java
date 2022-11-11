package vista;

import DTO.SucursalDTO;
import DTO.UsuarioSistemaDTO;
import controller.ControllerParametros;
import controller.ControllerSucursal;
import model.UsuarioSistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmUsuario extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton nuevoUsuarioButton;
    private JButton modificarUsuarioButton;
    private JButton eliminarUsuarioButton;
    private JComboBox comboBox1;

    public FrmUsuario() {
        super("Usuarios");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoUsuario dialog = new FrmNuevoUsuario();
                dialog.setVisible(true);
            }
        });
        modificarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarUsuario dialog = new FrmModificarUsuario((UsuarioSistemaDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioSistemaDTO usuarioSistemaDTO = (UsuarioSistemaDTO) comboBox1.getSelectedItem();
                ControllerParametros.getInstancia().bajaUsuario(usuarioSistemaDTO);
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<UsuarioSistemaDTO> listaUsuarios = new ArrayList<UsuarioSistemaDTO>();
        for (UsuarioSistemaDTO usuarioSistemaDTO: ControllerParametros.getInstancia().getListaUsuariosDTO())
            listaUsuarios.add(usuarioSistemaDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaUsuarios);
        comboBox1.setModel(modelo);
    }
}
