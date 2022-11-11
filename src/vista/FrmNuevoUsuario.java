package vista;

import DTO.UsuarioSistemaDTO;
import controller.ControllerParametros;
import model.enums.TipoRol;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmNuevoUsuario extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmNuevoUsuario() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosComboRol();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioSistemaDTO usuarioSistemaDTO = new UsuarioSistemaDTO(textField1.getText(), textField2.getText(), passwordField1.toString(), textField3.getText(), textField4.getText(), parseInt(textField5.getText()), textField6.getText(), (TipoRol) comboBox1.getSelectedItem());
                ControllerParametros.getInstancia().altaUsuario(usuarioSistemaDTO);
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
