package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import DTO.SucursalDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import model.Paciente;
import model.Practicas;
import model.Sucursal;
import model.enums.TipoEstado;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FrmModificarPeticion extends JDialog {
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

    public FrmModificarPeticion(PeticionesDTO peticionesDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        comboBox1.setSelectedItem(peticionesDTO.paciente);
        comboBox3.setSelectedItem(peticionesDTO.sucursal);
        textField1.setText(peticionesDTO.ObraSocial);
        textField2.setText(peticionesDTO.fechaCarga);
        comboBox4.setSelectedItem(peticionesDTO.practicasAsociadas);
        textField4.setText(peticionesDTO.fechaEntrega);
        comboBox2.setSelectedItem(peticionesDTO.estado);
        textField5.setText(String.valueOf(peticionesDTO.nroPeticion));
        asignarDatosComboEstado();
        asignarDatosComboPaciente();
        asignarDatosComboSucursales();
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionesDTO = new PeticionesDTO((Paciente) comboBox1.getSelectedItem(), (Sucursal) comboBox2.getSelectedItem(), textField1.getText(), textField2.getText(), (List<Practicas>) comboBox4.getSelectedItem(), textField4.getText(), TipoEstado.En_proceso, parseInt(textField5.getText()));
                ControllerPeticiones.getInstancia().modificacionPeticion(peticionesDTO);
                setVisible(false);
            }
        });
    }

    private void asignarDatosComboPaciente() {
        ArrayList<PacienteDTO> listaPacientes = new ArrayList<PacienteDTO>();
        for (PacienteDTO pacienteDTO : ControllerSucursal.getInstancia().getListaPacienteDTO())
            listaPacientes.add(pacienteDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaPacientes);
        comboBox1.setModel(modelo);
    }

    private void asignarDatosComboSucursales() {
        ArrayList<SucursalDTO> listaSucursales = new ArrayList<SucursalDTO>();
        for (SucursalDTO sucursalDTO : ControllerSucursal.getInstancia().getListaSucursalDTO())
            listaSucursales.add(sucursalDTO);


        DefaultComboBoxModel modeloSucursal = new DefaultComboBoxModel();
        modeloSucursal.addAll(listaSucursales);
        comboBox3.setModel(modeloSucursal);
    }

    private void asignarDatosComboEstado() {
        ArrayList<TipoEstado> listaEstados = new ArrayList<TipoEstado>();
        for (TipoEstado tipoEstado : TipoEstado.values()) {
            listaEstados.add(tipoEstado);
        }
        DefaultComboBoxModel modeloEstado = new DefaultComboBoxModel();
        modeloEstado.addAll(listaEstados);
        comboBox2.setModel(modeloEstado);
    }
}
