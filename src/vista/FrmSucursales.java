package vista;

import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmSucursales extends JInternalFrame {

    private JPanel pnlPrincipal;
    private JButton nuevaSucursalButton;
    private JButton modificarSucursalButton;
    private JButton eliminarSucursalButton;
    private JButton listarPacientesButton;
    private JButton listarPeticionesButton;
    private JButton listarPracticasButton;
    private JComboBox comboBox1;


    public FrmSucursales(){
        super("Sucursales");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevaSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevaSucursal dialog = new FrmNuevaSucursal();
                dialog.setVisible(true);

            }
        });
        modificarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarSucursal dialog = new FrmModificarSucursal((SucursalDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });

        eliminarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO suc = (SucursalDTO) comboBox1.getSelectedItem();
                SucursalDTO suc2 = (SucursalDTO) comboBox1.getItemAt(0);
                ControllerSucursal.getInstancia().bajaSucursal(suc, suc2);
            }
        });
        listarPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListaPacientesSucursal dialog = new FrmListaPacientesSucursal((SucursalDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
            }
        });
    }
    private void asignarDatosCombo() {
        ArrayList<SucursalDTO> listaSucursales = new ArrayList<SucursalDTO>();
        for (SucursalDTO sucursalDTO: ControllerSucursal.getInstancia().getListaSucursalDTO())
            listaSucursales.add(sucursalDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaSucursales);
        comboBox1.setModel(modelo);
    }
}
