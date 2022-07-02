package service;

import models.Curso;
import models.Disciplina;
import repository.DisciplinaRepository;

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

    public void atualizarDisciplina(Disciplina disciplina) {
        int controle = 2;
        try {
            if (disciplinaRepository.)
        }
    }



}
