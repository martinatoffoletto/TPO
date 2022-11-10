package vista;

import DTO.PacienteDTO;
import DTO.PeticionesDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import model.Peticiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPeticiones extends JInternalFrame{
    private JButton nuevaPeticionButton;
    private JButton modificarPeticionButton;
    private JButton eliminarPeticionButton;
    private JPanel pnlPrincipal;
    private JButton datosPeticionButton;
    private JComboBox comboBox1;

    public FrmPeticiones() {
        super("Peticiones");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevaPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaPeticion dialog = new FrmNuevaPeticion();
                dialog.setVisible(true);
            }
        });
        modificarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarPeticion dialog = new FrmModificarPeticion((PeticionesDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });
        eliminarPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PeticionesDTO peticionesDTO = (PeticionesDTO) comboBox1.getSelectedItem();
                ControllerPeticiones.getInstancia().bajaPeticion(peticionesDTO);
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
}
