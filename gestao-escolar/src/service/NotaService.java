package service;

import models.Aluno;
import models.DisciplinaXCurso;
import models.Nota;
import repository.DisciplinaXCursoRepository;
import repository.NotaRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NotaService {

    NotaRepository notaRepository;

    public NotaService() {
        notaRepository = new NotaRepository();
    }

    public void adicionerNotasAluno(Integer idCurso, Integer idAluno) {
        DisciplinaXCursoRepository disciplinaXCursoRepository = new DisciplinaXCursoRepository();

        try {
            List<DisciplinaXCurso> listaDiciplinaXCurso = disciplinaXCursoRepository.listarPorCurso(idCurso);

            for (DisciplinaXCurso itemDisciplinaXCurso : listaDiciplinaXCurso) {
                Nota nota = new Nota();
                nota.setIdDisciplina(itemDisciplinaXCurso.getIdDisciplina());
                nota.setIdAluno(idAluno);
                nota.setNota1(0.0);
                nota.setNota2(0.0);
                nota.setNota3(0.0);
                nota.setNota4(0.0);
                nota.setMedia(0.0);
                notaRepository.adicionerNotasAluno(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void atualizarNotasAluno() {
        Scanner scanner = new Scanner(System.in);
        AlunoService alunoService = new AlunoService();
        Integer escolhaAluno;
        Integer idAluno;
        Integer idCursoEscolhaAluno;
        DisciplinaXCursoRepository disciplinaXCursoRepository = new DisciplinaXCursoRepository();

        System.out.println("Deseja adicionar notas para qual aluno? ");
        alunoService.listarAlunos();
        escolhaAluno = Integer.parseInt(scanner.nextLine());
        idAluno = alunoService.listarAlunos().get(escolhaAluno - 1).getIdAluno();
        idCursoEscolhaAluno = alunoService.listarAlunos().get(escolhaAluno - 1).getIdCurso();

        try {
            List<DisciplinaXCurso> listaDiciplinaXCurso = disciplinaXCursoRepository.listarPorCurso(idCursoEscolhaAluno);

            for (DisciplinaXCurso itemDisciplinaXCurso : listaDiciplinaXCurso) {
                Nota nota = new Nota();
                nota.setIdDisciplina(itemDisciplinaXCurso.getIdDisciplina());
                nota.setIdAluno(idAluno);
                nota.setNota1(0.0);
                nota.setNota2(0.0);
                nota.setNota3(0.0);
                nota.setNota4(0.0);
                nota.setMedia(0.0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
