package DAO;

import model.Practicas;
import model.Sucursal;
import util.GenericDAO;

public class PracticasDAO extends GenericDAO<Practicas> {
    public PracticasDAO() throws Exception {
        super(Practicas.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\Practicas.txt");
    }
}
