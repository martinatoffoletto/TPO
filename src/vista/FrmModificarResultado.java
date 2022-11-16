package vista;

import DTO.ResultadoDTO;
import controller.ControllerPeticiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class FrmModificarResultado extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton guardarButton;
    private JPanel pnlPrincipal;
    private JLabel ID;

    public FrmModificarResultado(ResultadoDTO resultadoDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

        ID.setText(String.valueOf(resultadoDTO.ID));
        textField2.setText(String.valueOf(resultadoDTO.valorNumerico));
        textField3.setText(String.valueOf(resultadoDTO.valorBooleano));
        textField4.setText(String.valueOf(resultadoDTO.peticion.nroPeticion));
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoDTO resultado1 = new ResultadoDTO(parseInt(ID.getText()), resultadoDTO.peticion);
                if (textField2.getText() != "")
                    resultado1.valorNumerico = parseInt(textField2.getText());
                if (textField3.getText() != "")
                    resultado1.valorBooleano = parseBoolean(textField3.getText());
                ControllerPeticiones.getInstancia().modificacionResultado(resultado1);
                setVisible(false);
            }
        });
    }
}
