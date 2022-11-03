package vista;

import javax.swing.*;
import java.awt.*;

public class FrmNuevaSucursal extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmNuevaSucursal() {
        super();
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
    }
}
