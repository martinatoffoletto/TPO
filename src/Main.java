import DTO.SucursalDTO;
import controller.ControllerParametros;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import vista.FrmMenuPrincipal;
import vista.FrmSucursales;

import javax.naming.ldap.Control;

import static java.lang.Integer.parseInt;

public class Main {


    //FUNCION ERRORES TYPEO.





    public static void main(String[] args) {
        ControllerSucursal.getInstancia();
        ControllerParametros.getInstancia();
        ControllerPeticiones.getInstancia();
        FrmMenuPrincipal win = new FrmMenuPrincipal();
        win.setVisible(true);
        SucursalDTO suc = new SucursalDTO(1, "123", "Texto");

    }
}
