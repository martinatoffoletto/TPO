package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.PracticasDTO;
import DTO.SucursalDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import model.Paciente;
import model.Practicas;
import model.Sucursal;
import model.enums.TipoEstado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FrmNuevaPeticion extends JDialog {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox3;
    private JComboBox comboBox4;

    public FrmNuevaPeticion() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        asignarDatosComboPaciente();
        asignarDatosComboSucursales();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionesDTO = new PeticionesDTO((PacienteDTO) comboBox1.getSelectedItem(), (SucursalDTO) comboBox2.getSelectedItem(), textField1.getText(), textField2.getText(), (PracticasDTO) comboBox4.getSelectedItem(), textField4.getText(), TipoEstado.En_proceso, parseInt(textField5.getText()));
                ControllerPeticiones.getInstancia().altaPeticion(peticionesDTO);
                setVisible(false);
            }
        });
    }

    private void asignarDatosComboPaciente() {
        ArrayList<PacienteDTO> listaPacientes = new ArrayList<PacienteDTO>();
        for (PacienteDTO pacienteDTO: ControllerSucursal.getInstancia().getListaPacienteDTO())
            listaPacientes.add(pacienteDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaPacientes);
        comboBox1.setModel(modelo);
    }
    private void asignarDatosComboSucursales() {
        ArrayList<SucursalDTO> listaSucursales = new ArrayList<SucursalDTO>();
        for (SucursalDTO sucursalDTO: ControllerSucursal.getInstancia().getListaSucursalDTO())
            listaSucursales.add(sucursalDTO);


        DefaultComboBoxModel modeloSucursal = new DefaultComboBoxModel();
        modeloSucursal.addAll(listaSucursales);
        comboBox3.setModel(modeloSucursal);
    }

}
