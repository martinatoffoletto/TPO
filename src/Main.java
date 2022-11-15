import DTO.*;
import controller.ControllerParametros;
import controller.ControllerPeticiones;
import controller.ControllerSucursal;
import model.Paciente;
import model.enums.TipoEstado;
import model.enums.TipoRango;
import model.enums.TipoRol;
import model.enums.TipoValor;
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
        SucursalDTO suc = new SucursalDTO(1, "123", "Ejemplo");
        ControllerSucursal.getInstancia().altaSucursal(suc);
        SucursalDTO suc2 = new SucursalDTO(2, "1234", "Ejemplo2");
        ControllerSucursal.getInstancia().altaSucursal(suc2);
        PacienteDTO pac = new PacienteDTO(123, "Juan", "123", "mail", "F", 18);
        ControllerSucursal.getInstancia().altaPaciente(pac);
        //ReglaDTO reg = new ReglaDTO(1);
        //ControllerParametros.getInstancia().altaRegla(reg);
        //PracticasDTO prac = new PracticasDTO(123, "Practica", "2", TipoValor.BOOLEAN, TipoValor.BOOLEAN, 2, );
        //ControllerParametros.getInstancia().altaPractica(prac);
        ResultadoDTO resultadoDTO = new ResultadoDTO(1);
        ControllerPeticiones.getInstancia().altaResultados(resultadoDTO);
    }
}
