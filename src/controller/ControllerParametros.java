package controller;

import model.UsuarioSistema;

import java.util.List;

public class ControllerParametros {

    private static ControllerParametros instancia;

    public static ControllerParametros getInstancia() {
        if (instancia == null)
            instancia = new ControllerParametros();
        return instancia;
    }


    public void altaUsuario() {
        UsuarioSistema usuarioSistema = new UsuarioSistema(String usuario, email, password, nombre, domicilio)
    }

    public void bajaUsuario() {

    }

    public void modificacionUsuario() {

    }

    public void altaPractica() {

    }

    public void bajaPractica() {

    }

    public void modificacionPractica() {

    }

    public void altaSucursal() {

    }

    public void bajaSucursal() {

    }
    public void modificacionSucursal() {

    }
}
