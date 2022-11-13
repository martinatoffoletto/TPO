package vista;

import DTO.PracticasDTO;
import DTO.ReglaDTO;
import controller.ControllerParametros;
import model.Regla;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmModificarPractica extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox3;

    public FrmModificarPractica(PracticasDTO practicasDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        textField1.setText(String.valueOf(practicasDTO.codigo));
        textField2.setText(practicasDTO.nombrePractica);
        textField3.setText(practicasDTO.grupo);
        comboBox1.setSelectedItem(practicasDTO.valoresCriticos);
        comboBox2.setSelectedItem(practicasDTO.valoresReservados);
        textField4.setText(String.valueOf(practicasDTO.horasResultado));
        asignarDatosCombo();
        asignarDatosComboPracticas();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PracticasDTO practicasDTO = new PracticasDTO(parseInt(textField1.getText()), textField2.getText(), textField3.getText(), (TipoValor) comboBox1.getSelectedItem(), (TipoValor) comboBox2.getSelectedItem(), parseInt(textField4.getText()), (Regla) comboBox3.getSelectedItem());
                ControllerParametros.getInstancia().modificacionPractica(practicasDTO);
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

    private void asignarDatosComboPracticas() {
        ArrayList<ReglaDTO> listaReglas = new ArrayList<ReglaDTO>();
        for (ReglaDTO regla: ControllerParametros.getInstancia().listaReglaDTO) {
            listaReglas.add(regla);
        }

        DefaultComboBoxModel modeloReglas = new DefaultComboBoxModel();
        modeloReglas.addAll(listaReglas);
        comboBox3.setModel(modeloReglas);
    }
}
