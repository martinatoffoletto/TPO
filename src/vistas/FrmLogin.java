package vistas;

import javax.swing.*;

public class FrmLogin extends JFrame {
    private JTextArea textArea1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JPanel pnlLogin;

    public FrmLogin() {
        super("Login");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(pnlLogin);
    }
}
