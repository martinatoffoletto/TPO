package DAO;

import DTO.ReglaDTO;
import model.Paciente;
import util.GenericDAO;

public class ReglaDTODAO extends GenericDAO<ReglaDTO> {
    public ReglaDTODAO() throws Exception {
        super(ReglaDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\ReglaDTO.txt");
    }
}
