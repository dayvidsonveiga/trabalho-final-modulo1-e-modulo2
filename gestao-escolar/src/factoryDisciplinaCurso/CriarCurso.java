package factoryDisciplinaCurso;

import models.Aluno;
import models.Curso;

import java.util.ArrayList;

public class CriarCurso{
    public Curso criarCurso(String nomeDoCurso) {
        if ("Ensino Médio".equals(nomeDoCurso)) {
            ArrayList<Aluno> alunos = new ArrayList<>();
            Curso ensinoMedio = new Curso(nomeDoCurso);
            CriarDisciplina criarDisciplina = new CriarDisciplina();
            ensinoMedio.setDisciplinas(criarDisciplina.criarDisciplina(nomeDoCurso));
            ensinoMedio.setAlunos(alunos);
            return ensinoMedio;
        }
        return null;
    }
}
