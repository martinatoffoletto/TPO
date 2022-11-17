package vista;

import DTO.PeticionesDTO;
import DTO.ResultadoDTO;
import controller.ControllerPeticiones;

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
        for (ResultadoDTO resultadoDTO: ControllerPeticiones.getInstancia().listaResultadosDTO)
            if (resultadoDTO.ID == peticionesDTO.resultadoDTO) {
                ValorBooleano.setText(String.valueOf(resultadoDTO.valorNumerico));
                ID.setText(String.valueOf(resultadoDTO.ID));
            }
    }
}
