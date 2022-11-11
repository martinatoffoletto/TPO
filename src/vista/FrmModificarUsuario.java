package vista;

import DTO.UsuarioSistemaDTO;
import controller.ControllerParametros;
import model.enums.TipoRol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmModificarUsuario extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmModificarUsuario(UsuarioSistemaDTO usuarioSistemaDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        textField1.setText(usuarioSistemaDTO.usuario);
        textField2.setText(usuarioSistemaDTO.email);
        passwordField1.setText(usuarioSistemaDTO.password);
        textField4.setText(usuarioSistemaDTO.nombre);
        textField5.setText(usuarioSistemaDTO.domicilio);
        textField6.setText(String.valueOf(usuarioSistemaDTO.DNI));
        textField7.setText(usuarioSistemaDTO.nacimiento);
        comboBox1.setSelectedItem(usuarioSistemaDTO.rol);
        asignarDatosComboRol();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioSistemaDTO usuarioSistemaDTO = new UsuarioSistemaDTO(textField1.getText(), textField2.getText(), passwordField1.toString(), textField4.getText(), textField5.getText(), parseInt(textField6.getText()), textField7.getText(), (TipoRol) comboBox1.getSelectedItem());
                ControllerParametros.getInstancia().modificacionUsuario(usuarioSistemaDTO);
                setVisible(false);
            }
        });
    }

    private void asignarDatosComboRol() {
        ArrayList<TipoRol> listaRoles = new ArrayList<TipoRol>();
        for (TipoRol tipoRol: TipoRol.values()) {
            listaRoles.add(tipoRol);
        }

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaRoles);
        comboBox1.setModel(modelo);
    }
}
