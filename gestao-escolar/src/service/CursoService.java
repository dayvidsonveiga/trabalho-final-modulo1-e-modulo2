package service;

import models.Curso;
import models.Disciplina;
import repository.CursoRepository;
import service.factory.CursoDisciplinaFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CursoService {

    CursoRepository cursoRepository;

    public CursoService() {
        cursoRepository = new CursoRepository();
    }

    public void adicionarCurso() {

        Curso curso = CursoDisciplinaFactory.criarCurso();

        try {
            if (!(this.conferirSeCursoExiste(curso))) {
                cursoRepository.adicionar(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public Boolean conferirSeCursoExiste(Curso curso) throws SQLException {
        Boolean controle = false;
        int posicao = 0;
        List<Curso> cursosDb = cursoRepository.listar();
        for (Curso db : cursosDb) {
            controle = db.getNome().equals(curso.getNome());
            if (controle) {
                posicao = db.getIdCurso();
            }
        }
        if (posicao != 0) {
            curso.setIdCurso(posicao);
            return true;
        }
        return false;
    }

    public void atualizarCurso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o numero referente ao Curso que deseja atualizar: ");

        int controleNome = 0;
        Integer escolhaCurso = 0;
        listarCurso();
        escolhaCurso = Integer.parseInt(scanner.nextLine());
        Curso cursoEscolhido = listarCurso().get(escolhaCurso - 1);

        try {
            if (cursoRepository.conferirIdCurso(cursoEscolhido.getIdCurso())) {
                System.out.println("Atualizar nome do Curso? [1 - Sim / 2 - Não]");
                controleNome = Integer.parseInt(scanner.nextLine());
                if (controleNome == 1) {
                    System.out.println("Informe o novo Nome do Curso: ");
                    cursoEscolhido.setNome(scanner.nextLine());
                } else {
                    System.out.println("Nome atual do Curso: " + cursoEscolhido.getNome());
                }

                cursoRepository.editar(cursoEscolhido.getIdCurso(), cursoEscolhido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void removerCurso() {
        Integer escolhaCurso = 0;
        Integer cursoEscolhido = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual curso deseja remover?");
        listarCurso();
        escolhaCurso = Integer.parseInt(scanner.nextLine());
        cursoEscolhido = listarCurso().get(escolhaCurso - 1).getIdCurso();
        System.out.println(cursoEscolhido);
        try {
            cursoRepository.remover(cursoEscolhido);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    private List<Curso> listarCurso() {
        try {
            List<Curso> cursos = cursoRepository.listar();
            for (int i = 0; i < cursos.size(); i++) {
                System.out.println((i + 1) + " - " + cursos.get(i).getNome());
            }
            return cursos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void adicionarDisciplinaCurso() {
        int escolhaCurso = 0;
        int idCurso = 0;
        int escolhaDisciplina = 0;
        int idDisciplina = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("A qual curso deseja adicionar a disciplina: ");
        listarCurso();
        escolhaCurso = Integer.parseInt(scanner.nextLine());
        idCurso = listarCurso().get(escolhaCurso - 1).getIdCurso();

        System.out.println("Escolha a disciplina a ser adicionada: ");
        DisciplinaService disciplinaService = new DisciplinaService();
        disciplinaService.listarDisciplina();
        escolhaDisciplina = Integer.parseInt(scanner.nextLine());
        idDisciplina = disciplinaService.listarDisciplina().get(escolhaDisciplina).getIdDisciplina();


//        cursoXdisciplinaAdicionarDisciplinaCurso(idDisciplina, idCurso);


    }

}
