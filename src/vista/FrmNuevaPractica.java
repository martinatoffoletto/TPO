package vista;

import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerParametros;
import controller.ControllerSucursal;
import model.enums.TipoEstado;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmNuevaPractica extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmNuevaPractica() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PracticasDTO practicasDTO = new PracticasDTO(parseInt(textField1.getText()), textField2.getText(), textField3.getText(), (TipoValor) comboBox1.getSelectedItem(), (TipoValor) comboBox2.getSelectedItem(), parseInt(textField4.getText()));
                ControllerParametros.getInstancia().altaPractica(practicasDTO);
                setVisible(false);
            }
        });
    }
    private void asignarDatosCombo() {
        ArrayList<TipoValor> listaValores = new ArrayList<TipoValor>();
        for (TipoValor tipoValor: TipoValor.values()) {
            listaValores.add(tipoValor);
        }




        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaValores);
        comboBox1.setModel(modelo);
        comboBox2.setModel(modelo);
    }
}
