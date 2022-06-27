package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Aluno extends Pessoa{
    private Integer matricula;
    private Curso curso;
    private HashMap<String, ArrayList<Double>> notas = new HashMap<String, ArrayList<Double>>();

    private static Integer controleMatricula = 1000;

    public Aluno() {}
    public Aluno(String nome) {
        super(nome);
        this.matricula = ++controleMatricula;
    }

    public Aluno(String nome, String telefone, String email, Endereco endereco, Curso curso) {
        super(nome, telefone, email, endereco);
        this.matricula = ++controleMatricula;
        this.curso = curso;
    }

    public Integer getMatricula() {
        return this.matricula;
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

    public void setNotas(String disciplina, ArrayList<Double> nota) {
        this.notas.put(disciplina, nota);
    }

    public HashMap<String, ArrayList<Double>> getNotas() {
        return notas;
    }

    public void getNotasImprimir() {
         notas.keySet().forEach(chave -> {
             System.out.println("Disciplina: " + chave + " Nota: " + notas.get(chave) + " Média: " + (notas.get(chave).get(0) + notas.get(chave).get(1)) / 2);
         });
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() +
                " | Matrícula: " + this.matricula;
    }
}
