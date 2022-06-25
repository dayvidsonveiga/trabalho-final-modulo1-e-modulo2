package models;

public class Disciplina {
    private String curso;
    private Colaborador professor;

    public Disciplina(String curso) {
        this.curso = curso;
    }

    public Disciplina(Colaborador professor) {
        this.professor = professor;
    }

    public Disciplina(String curso, Colaborador professor) {
        this.curso = curso;
        this.professor = professor;
    }

    public void imprimirDisciplina() {};

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Colaborador getProfessor() {
        return professor;
    }

    public void setProfessor(Colaborador professor) {
        this.professor = professor;
    }
}
