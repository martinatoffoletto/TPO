package DAO;

import model.Practicas;
import model.UsuarioSistema;
import util.GenericDAO;

public class UsuarioSistemaDAO extends GenericDAO<UsuarioSistema> {
    public UsuarioSistemaDAO() throws Exception {
        super(UsuarioSistema.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\UsuarioSistema.txt");
    }
}
