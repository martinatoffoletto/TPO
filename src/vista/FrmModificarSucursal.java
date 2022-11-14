package vista;

import DTO.SucursalDTO;
import controller.ControllerSucursal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;


public class FrmModificarSucursal extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel Numero;

    public FrmModificarSucursal(SucursalDTO sucursalDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        Numero.setText(String.valueOf(sucursalDTO.numero));
        textField2.setText(sucursalDTO.direccion);
        textField3.setText(sucursalDTO.responsableTecnico);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO suc = new SucursalDTO(parseInt(Numero.getText()), textField2.getText(), textField3.getText());
                ControllerSucursal.getInstancia().modificacionSucursal(suc);
                setVisible(false);
            }
        });
    }
}
