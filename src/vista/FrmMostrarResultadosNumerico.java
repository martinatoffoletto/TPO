package vista;

import DTO.PeticionesDTO;
import model.enums.TipoValor;

import javax.swing.*;

public class FrmMostrarResultadosNumerico extends JDialog {
    private JPanel pnlPrincipal;
    private JLabel ID;
    private JLabel ValorNumerico;
    private JLabel ValorBooleano;
    private JLabel numerico;
    private JLabel booleano;

    public FrmMostrarResultadosNumerico(PeticionesDTO peticionesDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        ValorNumerico.setText(String.valueOf(peticionesDTO.resultadoDTO.valorNumerico));
        ID.setText(String.valueOf(peticionesDTO.resultadoDTO.ID));

    }
}
