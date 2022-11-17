package DAO;

import model.Paciente;
import util.GenericDAO;


public class PacienteDAO extends GenericDAO<Paciente> {
    public PacienteDAO() throws Exception {
        super(Paciente.class, "C:\\Users\\tomij\\OneDrive\\Documentos\\GitHub\\TPO\\src\\txt\\Paciente.txt");
    }
}
