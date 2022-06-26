package models;

import java.util.HashMap;

public class Aluno extends Pessoa{
    private Integer matricula;
    private Curso curso;
    private HashMap<Disciplina, Double> nota1, nota2, media;

    private static Integer controleMatricula = 1000;

    public Aluno() {}
    public Aluno(String nome) {
        super(nome);
        this.matricula = ++controleMatricula;
    }

    public Aluno(String nome, String telefone, String email, Endereco endereco, Integer tipo, Curso curso) {
        super(nome, telefone, email, endereco);
        this.matricula = ++controleMatricula;
        this.curso = curso;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
