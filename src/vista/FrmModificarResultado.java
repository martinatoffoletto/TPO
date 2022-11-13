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

    public FrmModificarResultado(ResultadoDTO resultadoDTO) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);

        textField1.setText(String.valueOf(resultadoDTO.ID));
        textField2.setText(String.valueOf(resultadoDTO.valorNumerico));
        textField3.setText(String.valueOf(resultadoDTO.valorBooleano));
        textField4.setText(resultadoDTO.descripcion);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoDTO resultado1 = new ResultadoDTO(parseInt(textField1.getText()));
                if (textField2.getText() != "")
                    resultado1.valorNumerico = parseInt(textField2.getText());
                if (textField3.getText() != "")
                    resultado1.valorBooleano = parseBoolean(textField3.getText());
                if (textField4.getText() != "")
                    resultado1.descripcion = textField4.getText();
                ControllerPeticiones.getInstancia().modificacionResultado(resultado1);
                setVisible(false);
            }
        });
    }
}
