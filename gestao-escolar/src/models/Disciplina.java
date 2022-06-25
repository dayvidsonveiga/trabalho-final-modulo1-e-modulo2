package models;

public class Disciplina {
    private String curso;
    private String nome;
    private Colaborador professor;

    public Disciplina(String curso) {
        this.curso = curso;
    }

    public Disciplina(Colaborador professor) {
        this.professor = professor;
    }

    public Disciplina(){}
    public Disciplina(String curso, Colaborador professor) {
        this.curso = curso;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return this.nome;
    }
}
