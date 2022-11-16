package vista;

import DTO.PeticionesDTO;
import controller.ControllerPeticiones;
import model.enums.TipoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPeticiones extends JInternalFrame {
    private JButton nuevaPeticionButton;
    private JButton modificarPeticionButton;
    private JButton eliminarPeticionButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton verResultadosButton;

    public FrmPeticiones() {
        super("Peticiones");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();

        nuevaPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmElegirSucursalPeticion dialog = new FrmElegirSucursalPeticion();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPeticion dialog = new FrmModificarPeticion((PeticionesDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionesDTO = (PeticionesDTO) comboBox1.getSelectedItem();
                ControllerPeticiones.getInstancia().bajaPeticion(peticionesDTO);
                asignarDatosCombo();
            }
        });
        verResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionDTO = (PeticionesDTO) comboBox1.getSelectedItem();
                if (peticionDTO.resultadoDTO != null) {
                    if (peticionDTO.practicaAsociada.regla.tipoValor == TipoValor.NUMERICO) {
                        FrmMostrarResultadosNumerico dialog = new FrmMostrarResultadosNumerico(peticionDTO);
                        dialog.setVisible(true);
                    } else {
                        FrmMostrarResultadoBooleano dialog = new FrmMostrarResultadoBooleano(peticionDTO);
                        dialog.setVisible(true);
                    }
                }
            }
        });
    }
        private void asignarDatosCombo () {
            ArrayList<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
            for (PeticionesDTO peticionesDTO : ControllerPeticiones.getInstancia().getListaPeticionesDTO())
                listaPeticiones.add(peticionesDTO);


            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            modelo.addAll(listaPeticiones);
            comboBox1.setModel(modelo);
        }
    }
