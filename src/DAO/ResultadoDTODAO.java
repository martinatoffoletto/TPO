package DAO;

import DTO.ResultadoDTO;
import model.Resultado;
import util.GenericDAO;

public class ResultadoDTODAO extends GenericDAO<ResultadoDTO> {
    public ResultadoDTODAO() throws Exception {
        super(ResultadoDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\ResultadoDTO.txt");
    }
}
