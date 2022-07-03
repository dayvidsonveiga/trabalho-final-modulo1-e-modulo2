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

}
