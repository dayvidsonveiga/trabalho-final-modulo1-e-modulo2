package models;

public class Disciplina {
    private Integer idDisciplina;
    private String nome;
    private Colaborador professor;

    public Disciplina(){}

    public Disciplina(String nome, Colaborador professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimirDisciplina() {

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
