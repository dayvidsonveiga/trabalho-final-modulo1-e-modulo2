package service;

import models.Aluno;
import repository.EnderecoRepository;
import repository.AlunoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AlunoService {
    AlunoRepository alunoRepository;

    public AlunoService() {
        alunoRepository = new AlunoRepository();
    }

    public void adicionarAluno(Aluno aluno) {
        try {
            alunoRepository.adicionar(aluno);
        } catch (SQLException e) {
            e.getCause();
        }
    }
}

