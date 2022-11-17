package DAO;

import model.Peticiones;
import util.GenericDAO;

public class PeticionesDAO extends GenericDAO<Peticiones> {
    public PeticionesDAO() throws Exception {
        super(Peticiones.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\Peticiones.txt");
    }
}
