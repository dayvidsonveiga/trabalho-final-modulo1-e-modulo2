package service;

import models.Colaborador;
import repository.ProfessorRepository;

import java.sql.SQLException;

public class ProfessorService {
    ProfessorRepository professorRepository;

    public ProfessorService() {
        professorRepository = new ProfessorRepository();
    }

    public void adicionarProfessor(Colaborador professor) {
        try {
            professorRepository.adicionar(professor);
        } catch (SQLException e) {
            e.getCause();
        }
    }
}
