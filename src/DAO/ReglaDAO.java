package DAO;

import model.Paciente;
import model.Regla;
import util.GenericDAO;

public class ReglaDAO extends GenericDAO<Regla> {
    public ReglaDAO() throws Exception {
        super(Regla.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\Regla.txt");
    }
}
