package vista;

import javax.swing.*;

public class FrmListarPeticionesPaciente extends JDialog {
    private JPanel pnlPrincipal;
    private JList list1;
    private JCheckBox listarEnValoresCriticosCheckBox;

    public FrmListarPeticionesPaciente() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }

}
