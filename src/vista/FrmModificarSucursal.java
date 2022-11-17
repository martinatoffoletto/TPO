package vista;

import DTO.SucursalDTO;
import DTO.UsuarioSistemaDTO;
import controller.ControllerParametros;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class FrmModificarSucursal extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel Numero;
    private JComboBox comboBox1;

    public FrmModificarSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        Numero.setText(String.valueOf(sucursalDTO.numero));
        textField2.setText(sucursalDTO.direccion);
        comboBox1.setSelectedItem(sucursalDTO.responsableTecnico);
        asignarDatosCombo();


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO suc = new SucursalDTO(parseInt(Numero.getText()), textField2.getText(), (UsuarioSistemaDTO) comboBox1.getSelectedItem());
                ControllerSucursal.getInstancia().modificacionSucursal(suc);
                setVisible(false);
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
