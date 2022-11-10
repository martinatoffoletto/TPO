package vista;

import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FrmNuevaSucursal extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JPanel pnlPrincipal;

    public FrmNuevaSucursal() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO suc = new SucursalDTO(parseInt(textField1.getText()), textField2.getText(), textField3.getText());
                ControllerSucursal.getInstancia().altaSucursal(suc);
                setVisible(false);

            }

        })
        ;
    }
}
