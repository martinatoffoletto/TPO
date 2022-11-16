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
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel Numero;
    private JLabel PacienteDNI;
    private JLabel SucursalNumero;
    private JLabel PracticaAsociada;

    public FrmModificarPeticion(PeticionesDTO peticionesDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        PacienteDTO pacienteDTO = peticionesDTO.paciente;
        SucursalDTO sucursalDTO = peticionesDTO.sucursal;
        PracticasDTO practicasDTO = peticionesDTO.practicaAsociada;
        PacienteDNI.setText(String.valueOf(pacienteDTO.DNI));
        SucursalNumero.setText(String.valueOf(sucursalDTO.numero));
        PracticaAsociada.setText(String.valueOf(practicasDTO.codigo));
        textField1.setText(peticionesDTO.ObraSocial);
        textField2.setText(peticionesDTO.fechaCarga);
        textField4.setText(peticionesDTO.fechaEntrega);
        Numero.setText(String.valueOf(peticionesDTO.nroPeticion));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionDTO = new PeticionesDTO(pacienteDTO, sucursalDTO, textField1.getText(), textField2.getText(), practicasDTO, textField4.getText(), peticionesDTO.estado, parseInt(Numero.getText()));
                ControllerPeticiones.getInstancia().modificacionPeticion(peticionDTO);
                setVisible(false);
            }
        });
    }

}
