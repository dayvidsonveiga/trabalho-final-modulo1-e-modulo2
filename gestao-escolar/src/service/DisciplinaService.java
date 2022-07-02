package service;

import models.Colaborador;
import models.Curso;
import models.Disciplina;
import repository.DisciplinaRepository;
import repository.ProfessorRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DisciplinaService {

    DisciplinaRepository disciplinaRepository;

    public DisciplinaService() {
        disciplinaRepository = new DisciplinaRepository();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        try {
            if (!(this.conferirSeDisciplinaExiste(disciplina))) {
                disciplinaRepository.adicionar(disciplina);
            }
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public Boolean conferirSeDisciplinaExiste(Disciplina disciplina) throws SQLException {
        Boolean controle = false;
        int posicao = 0;
        List<Disciplina> disciplinasDb = disciplinaRepository.listar();
        for (Disciplina db : disciplinasDb) {
            if (db.getNome() != null) {
                controle = db.getNome().equals(disciplina.getNome());
                if (controle) {
                    posicao = db.getIdDisciplina();
                }
            }
        }
        if (posicao != 0) {
            disciplina.setIdDisciplina(posicao);
            return true;
        }
        return false;
    }

    public void atualizarDisciplina(Disciplina disciplina) {
        int controle = 2;
        try {
            if (disciplinaRepository.conferirIdDisciplina(disciplina.getIdDisciplina())) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Atualizar nome da disciplina? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Nome: ");
                    disciplina.setNome(scanner.nextLine());
                } else {
                    System.out.println("Nome atual da disciplina: " + disciplina.getNome());
                }

                System.out.println("Alterar professor da disciplina? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Informe o numero referente ao professor: ");

                    //Faltando setar novo professor
                } else {
                    System.out.println("Nome do atual professor da disciplina: " + disciplina.getProfessor());
                }

                disciplinaRepository.editar(disciplina.getIdDisciplina(), disciplina);
            }
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public void removerDisciplina() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual disciplina deseja remover?");
        List<Disciplina> disciplinas = this.listarDisciplina();
        int opcao = (Integer.parseInt(scanner.nextLine())) - 1;
        try {
            Integer idEndereco = disciplinas.get(opcao).getIdDisciplina();
            disciplinaRepository.remover(disciplinas.get(opcao).getIdDisciplina());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Disciplina> listarDisciplina() {
        try {
            List<Disciplina> disciplinas = disciplinaRepository.listar();
            for (int i = 0; i < disciplinas.size(); i++) {
                System.out.println((i + 1) + " - " + disciplinas.get(i).getNome());
            }
            return disciplinas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
