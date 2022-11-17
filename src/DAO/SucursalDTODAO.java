package DAO;

import DTO.SucursalDTO;
import model.Sucursal;
import util.GenericDAO;

public class SucursalDTODAO extends GenericDAO<SucursalDTO> {
    public SucursalDTODAO() throws Exception {
        super(SucursalDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\SucursalDTO.txt");
    }
}
