package DAO;

import DTO.UsuarioSistemaDTO;
import model.UsuarioSistema;
import util.GenericDAO;

public class UsuarioSistemaDTODAO extends GenericDAO<UsuarioSistemaDTO> {
    public UsuarioSistemaDTODAO() throws Exception {
        super(UsuarioSistemaDTO.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\UsuarioSistemaDTO.txt");
    }
}
