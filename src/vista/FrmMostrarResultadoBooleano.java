package vista;

import DTO.PeticionesDTO;

import javax.swing.*;

public class FrmMostrarResultadoBooleano extends JDialog {
    private JPanel pnlPrincipal;
    private JLabel ID;
    private JLabel ValorBooleano;

    public FrmMostrarResultadoBooleano(PeticionesDTO peticionesDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        ValorBooleano.setText(String.valueOf(peticionesDTO.resultadoDTO.valorNumerico));
        ID.setText(String.valueOf(peticionesDTO.resultadoDTO.ID));
    }
}
