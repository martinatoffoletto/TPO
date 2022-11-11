package vista;

import DTO.ReglaDTO;
import model.Regla;

import javax.swing.*;

public class FrmModificarRegla extends JDialog {
    private JPanel pnlPrincipal;

    public FrmModificarRegla(ReglaDTO reglaDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }

}
