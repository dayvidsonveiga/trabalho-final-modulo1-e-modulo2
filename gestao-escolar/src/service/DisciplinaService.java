package service;

import models.Colaborador;
import models.Curso;
import models.Disciplina;
import repository.DisciplinaRepository;
import repository.ProfessorRepository;
import service.factory.CursoDisciplinaFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DisciplinaService {

    DisciplinaRepository disciplinaRepository;

    public DisciplinaService() {
        disciplinaRepository = new DisciplinaRepository();
    }

    public void adicionarDisciplina() {

        Disciplina disciplina = CursoDisciplinaFactory.criarDisciplina();

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
            controle = db.getNome().equals(disciplina.getNome());
            if (controle) {
                posicao = db.getIdDisciplina();
            }

        }
        if (posicao != 0) {
            disciplina.setIdDisciplina(posicao);
            return true;
        }
        return false;
    }

    public void atualizarDisciplina() {
        Scanner scanner = new Scanner(System.in);

        int controleNome = 0;
        int controleProfessor = 0;
        Integer escolhaDisciplina = 0;
        DisciplinaService disciplinaService = new DisciplinaService();
        disciplinaService.listarDisciplina();
        escolhaDisciplina = Integer.parseInt(scanner.nextLine());
        Disciplina disciplinaEscolhida = disciplinaService.listarDisciplina().get(escolhaDisciplina - 1);

        try {
            if (disciplinaRepository.conferirIdDisciplina(disciplinaEscolhida.getIdDisciplina())) {

                System.out.println("Atualizar nome da disciplina? [1 - Sim / 2 - Não]");
                controleNome = Integer.parseInt(scanner.nextLine());
                if (controleNome == 1) {
                    System.out.println("Informe o novo Nome da Disciplina: ");
                    disciplinaEscolhida.setNome(scanner.nextLine());
                } else {
                    System.out.println("Nome atual da disciplina: " + disciplinaEscolhida.getNome());
                }

                System.out.println("Alterar professor da disciplina? [1 - Sim / 2 - Não]");
                controleProfessor = Integer.parseInt(scanner.nextLine());

                if (controleProfessor == 1) {
                    System.out.println("Informe o numero referente ao professor: ");
                    ProfessorService professorService = new ProfessorService();
                    professorService.listarProfessores();
                    int escolhaProfessor = Integer.parseInt(scanner.nextLine());
                    Colaborador professorEscolhido = professorService.listarProfessores().get(escolhaProfessor - 1);
                    disciplinaEscolhida.setProfessor(professorEscolhido);
                } else {
                    System.out.println("Nome do atual professor da disciplina: " + disciplinaEscolhida.getProfessor());
                }

                disciplinaRepository.editar(disciplinaEscolhida.getIdDisciplina(), disciplinaEscolhida);
            }
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public void removerDisciplina() {
        Integer escolhaDisciplina = 0;
        Integer disciplinaEscolhida = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual disciplina deseja remover?");
        listarDisciplina();
        escolhaDisciplina = Integer.parseInt(scanner.nextLine());
        disciplinaEscolhida = listarDisciplina().get(escolhaDisciplina - 1).getIdDisciplina();
        System.out.println(disciplinaEscolhida);
        try {
            disciplinaRepository.remover(disciplinaEscolhida);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void imprimirInformacoesDisciplina() {
        //Em construção
        Integer escolhaDisciplina = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sobre qual disciplina deseja saber? ");
        listarDisciplina();
        escolhaDisciplina = Integer.parseInt(scanner.nextLine());
        Disciplina disciplina = listarDisciplina().get(escolhaDisciplina - 1);
        System.out.println(disciplina.getProfessor());
        System.out.println(disciplina.getNome());
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
