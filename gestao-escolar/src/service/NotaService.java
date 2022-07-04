package service;

import models.Aluno;
import models.Disciplina;
import models.DisciplinaXCurso;
import models.Nota;
import repository.DisciplinaRepository;
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
        Integer escolhaDisciplina;
        Integer idAluno;
        Integer idCursoEscolhaAluno;
        DisciplinaXCursoRepository disciplinaXCursoRepository = new DisciplinaXCursoRepository();

        System.out.println("Deseja alterar notas de qual aluno? ");
        List<Aluno> alunos = alunoService.listarAlunos();
        escolhaAluno = Integer.parseInt(scanner.nextLine());
        idAluno = alunos.get(escolhaAluno - 1).getIdAluno();
        idCursoEscolhaAluno = alunos.get(escolhaAluno - 1).getIdCurso();

        System.out.println("Escolha a disciplina: ");
        try {
            DisciplinaRepository disciplinaRepository = new DisciplinaRepository();
            List<Disciplina> listaDisciplina = disciplinaRepository.listarPorId(disciplinaXCursoRepository.listarPorCurso(idCursoEscolhaAluno));
            for (int i = 0; i < listaDisciplina.size(); i++) {
                System.out.println((i + 1) + " - " + listaDisciplina.get(i).getNome());
            }


//            for (Disciplina disciplina : listaDisciplina) {
//                System.out.println();
//            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        escolhaDisciplina = Integer.parseInt(scanner.nextLine());
        System.out.println(escolhaDisciplina);


//        try {
//            List<DisciplinaXCurso> listaDiciplinaXCurso = disciplinaXCursoRepository.listarPorCurso(idCursoEscolhaAluno);
//
//            for (DisciplinaXCurso itemDisciplinaXCurso : listaDiciplinaXCurso) {
//                Nota nota = new Nota();
//                nota.setIdDisciplina(itemDisciplinaXCurso.getIdDisciplina());
//                nota.setIdAluno(idAluno);
//                nota.setNota1(0.0);
//                nota.setNota2(0.0);
//                nota.setNota3(0.0);
//                nota.setNota4(0.0);
//                nota.setMedia(0.0);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            e.getCause();
//        }
//    }
    }
}
