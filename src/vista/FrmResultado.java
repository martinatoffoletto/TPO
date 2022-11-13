package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        nuevoResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmNuevoResultado dialog = new FrmNuevoResultado();
                dialog.setVisible(true);
            }
        });
    }
}
