package service;

import models.Curso;
import models.Disciplina;
import repository.CursoRepository;
import service.factory.CursoDisciplinaFactory;

import java.sql.SQLException;
import java.util.List;

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

}
