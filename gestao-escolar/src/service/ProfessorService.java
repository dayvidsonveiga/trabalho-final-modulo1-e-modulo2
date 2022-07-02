package service;

import models.Colaborador;
import repository.ProfessorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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

    public void removerProfessor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual colaborador deseja remover?");
        List<Colaborador> professores = this.listarProfessores();
        int opcao = (Integer.parseInt(scanner.nextLine())) - 1;
        try {
            professorRepository.remover(professores.get(opcao).getIdColaborador());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Colaborador> listarProfessores() {
        try {
            List<Colaborador> colaboradores = professorRepository.listar();
            for (int i = 0; i < colaboradores.size(); i++) {
                System.out.println(i + " - " + colaboradores.get(i).getNome());
                return colaboradores;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
