package DAO;

import DTO.PacienteDTO;
import model.Sucursal;
import util.GenericDAO;

public class PacienteDTODAO extends GenericDAO<PacienteDTO> {
    public PacienteDTODAO() throws Exception {
        super(PacienteDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\PacienteDTO.txt");
    }
}
