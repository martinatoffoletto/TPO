package DAO;

import model.Sucursal;
import util.GenericDAO;

public class SucursalDAO extends GenericDAO<Sucursal> {
    public SucursalDAO() throws Exception {
        super(Sucursal.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\Sucursal.txt");
    }
}
