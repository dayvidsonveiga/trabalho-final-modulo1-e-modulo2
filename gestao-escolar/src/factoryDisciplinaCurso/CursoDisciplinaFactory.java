package factoryDisciplinaCurso;

import models.Aluno;
import models.Curso;

import java.util.ArrayList;

public class CursoDisciplinaFactory {
    public static Curso ensinoMedio(String nomeDoCurso) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Curso ensinoMedio = new Curso(nomeDoCurso);
        CriarDisciplina criarDisciplina = new CriarDisciplina();
        ensinoMedio.setDisciplinas(criarDisciplina.criarDisciplina(nomeDoCurso));
        ensinoMedio.setAlunos(alunos);
        return ensinoMedio;
    }
}
