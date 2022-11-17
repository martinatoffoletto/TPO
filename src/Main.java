import DTO.*;
import controller.ControllerParametros;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import model.Paciente;
import model.UsuarioSistema;
import model.enums.TipoEstado;
import model.enums.TipoRango;
import model.enums.TipoRol;
import model.enums.TipoValor;
import vista.FrmLogin;
import vista.FrmMenuPrincipal;
import vista.FrmSucursales;

import javax.naming.ldap.Control;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        ControllerSucursal.getInstancia();
        ControllerParametros.getInstancia();
        ControllerPeticiones.getInstancia();
        FrmLogin win = new FrmLogin();
        win.setVisible(true);
    }
}
