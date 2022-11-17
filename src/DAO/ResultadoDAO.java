package DAO;

import model.Resultado;
import model.UsuarioSistema;
import util.GenericDAO;

public class ResultadoDAO extends GenericDAO<Resultado> {
    public ResultadoDAO() throws Exception {
        super(Resultado.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\Resultado.txt");
    }
}
