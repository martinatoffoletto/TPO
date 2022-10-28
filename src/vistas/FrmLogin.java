package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLogin extends JFrame {
    private JTextArea textArea1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JPanel pnlLogin;

    public FrmLogin() {
        super("Login");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(pnlLogin);
    }
}
