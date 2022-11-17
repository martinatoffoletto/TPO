package vista;

import DTO.UsuarioSistemaDTO;
import controller.ControllerParametros;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmLogin extends JFrame{
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton ingresarButton;
    private JButton cerrarButton;

    public FrmLogin() {
        super("Login");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal((UsuarioSistemaDTO) comboBox1.getSelectedItem());
                menuPrincipal.setVisible(true);
                setVisible(false);
            }
        });
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerSucursal.getInstancia().cerrarController();
                ControllerParametros.getInstancia().cerrarController();
                ControllerPeticiones.getInstancia().cerrarController();
                System.exit(0);
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
