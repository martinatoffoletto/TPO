package DAO;

import DTO.PeticionesDTO;
import util.GenericDAO;

public class PeticionesDTODAO extends GenericDAO<PeticionesDTO> {
    public PeticionesDTODAO() throws Exception {
        super(PeticionesDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\PeticionesDTO.txt");
    }
}
