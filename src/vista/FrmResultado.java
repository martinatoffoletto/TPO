package vista;

import DTO.PacienteDTO;
import DTO.ResultadoDTO;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmResultado extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JButton nuevoResultadoButton;
    private JButton modificarResultadoButton;
    private JButton eliminarResultadoButton;

    public FrmResultado() {
        super("Resultado");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setContentPane(pnlPrincipal);
        asignarDatosCombo();
        nuevoResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoResultado dialog = new FrmNuevoResultado();
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        modificarResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmModificarResultado dialog = new FrmModificarResultado((ResultadoDTO) comboBox1.getSelectedItem());
                dialog.setVisible(true);
                asignarDatosCombo();
            }
        });
        eliminarResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoDTO resultadoDTO = (ResultadoDTO) comboBox1.getSelectedItem();
                ControllerPeticiones.getInstancia().bajaResultados(resultadoDTO);
                asignarDatosCombo();
            }
        });
    }

    private void asignarDatosCombo() {
        ArrayList<ResultadoDTO> listaResultados = new ArrayList<ResultadoDTO>();
        for (ResultadoDTO resultadoDTO: ControllerPeticiones.getInstancia().getListaResultadosDTO())
            listaResultados.add(resultadoDTO);


        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addAll(listaResultados);
        comboBox1.setModel(modelo);
    }
}
