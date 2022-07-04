package models;

public class Disciplina {
    private String nome;
    private Colaborador professor;

    public Disciplina(){}

    public Disciplina(String nome, Colaborador professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimirDisciplina() {};


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
