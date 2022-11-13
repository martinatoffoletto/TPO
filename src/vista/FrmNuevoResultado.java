package vista;

import DTO.ResultadoDTO;
import controller.ControllerParametros;
import controller.ControllerPeticiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class FrmNuevoResultado extends JDialog {
    private JPanel pnlPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton guardarButton;

    public FrmNuevoResultado() {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);
        setContentPane(pnlPrincipal);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultadoDTO resultadoDTO = new ResultadoDTO(parseInt(textField1.getText()));
                if (textField2.getText() != "")
                    resultadoDTO.valorNumerico = parseInt(textField2.getText());
                if (textField3.getText() != "")
                    resultadoDTO.valorBooleano = parseBoolean(textField3.getText());
                if (textField4.getText() != "")
                    resultadoDTO.descripcion = textField4.getText();
                ControllerPeticiones.getInstancia().altaResultados(resultadoDTO);
                setVisible(false);
            }
        });
    }
}
