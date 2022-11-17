package DAO;

import DTO.PracticasDTO;
import util.GenericDAO;

public class PracticasDTODAO extends GenericDAO<PracticasDTO> {
    public PracticasDTODAO() throws Exception {
        super(PracticasDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\PracticasDTO.txt");
    }
}
