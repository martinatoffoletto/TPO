package vista;

import DTO.PeticionesDTO;
import DTO.ResultadoDTO;
import controller.ControllerParametros;
import controller.ControllerPeticiones;
import model.Peticiones;
import model.enums.TipoEstado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class FrmNuevoResultado extends JDialog {
    private JPanel pnlPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton guardarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public FrmNuevoResultado() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        asignarDatosComboBoolean();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoDTO resultadoDTO = new ResultadoDTO(parseInt(textField1.getText()), (PeticionesDTO) comboBox1.getSelectedItem());
                if (!textField2.getText().isEmpty())
                    resultadoDTO.valorNumerico = parseInt(textField2.getText());
                if (comboBox2.getSelectedItem() != null)
                    resultadoDTO.valorBooleano = (boolean) comboBox2.getSelectedItem();
                ControllerPeticiones.getInstancia().altaResultados(resultadoDTO);
                setVisible(false);
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
        for (PeticionesDTO peticionesDTO: ControllerPeticiones.getInstancia().getListaPeticionesDTO())
            listaPeticiones.add(peticionesDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaPeticiones);
        comboBox1.setModel(modelo);
    }

    private void asignarDatosComboBoolean() {
        ArrayList<Boolean> listaBoolean = new ArrayList<>();
        listaBoolean.add(true);
        listaBoolean.add(false);

        DefaultComboBoxModel modeloB = new DefaultComboBoxModel();
        modeloB.addAll(listaBoolean);
        comboBox2.setModel(modeloB);
    }
}
