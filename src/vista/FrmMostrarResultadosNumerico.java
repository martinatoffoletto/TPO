package vista;

import DTO.PeticionesDTO;
import DTO.ResultadoDTO;
import controller.ControllerPeticiones;
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
        for (ResultadoDTO resultadoDTO: ControllerPeticiones.getInstancia().listaResultadosDTO)
            if (resultadoDTO.ID == peticionesDTO.resultadoDTO) {
                ValorNumerico.setText(String.valueOf(resultadoDTO.valorNumerico));
                ID.setText(String.valueOf(resultadoDTO.ID));
            }

    }
}
