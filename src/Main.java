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
        UsuarioSistemaDTO usu = new UsuarioSistemaDTO(1, "mailUsuario", "contraseña", "Administrador", "Domicilio Usuario", 1234, "01/01/2000", TipoRol.ADMINISTRADOR);
        ControllerParametros.getInstancia().altaUsuario(usu);
        UsuarioSistemaDTO usu2 = new UsuarioSistemaDTO(2, "mailUsuario", "contraseña", "Recepcionista", "Domicilio Usuario", 1234, "01/01/2000", TipoRol.RECEPCIONISTA);
        ControllerParametros.getInstancia().altaUsuario(usu2);
        UsuarioSistemaDTO usu3 = new UsuarioSistemaDTO(3, "mailUsuario", "contraseña", "Laboratorista", "Domicilio Usuario", 1234, "01/01/2000", TipoRol.LABORATORISTA);
        ControllerParametros.getInstancia().altaUsuario(usu3);
        FrmLogin win = new FrmLogin();
        win.setVisible(true);
    }
}
