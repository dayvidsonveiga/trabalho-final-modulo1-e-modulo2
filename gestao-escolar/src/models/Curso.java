package models;

import java.util.ArrayList;

public class Curso {
    private String nome;
    private Integer IdCurso;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(String nome, ArrayList<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Curso(String nome, ArrayList<Disciplina> disciplinas, ArrayList<Aluno> alunos) {
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer idCurso) {
        IdCurso = idCurso;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    public void setDisciplinas(Disciplina disciplinas) {
        Boolean contem = false;
        for (int i = 0; i < this.disciplinas.size(); i++) {
            if (this.disciplinas.get(i).getNome().equalsIgnoreCase(disciplinas.getNome())) {
                contem = true;
            } else {
                contem = false;
            }
        }
        if (contem) {
            System.out.println("Esta disciplina já existe no curso");
        }else {this.disciplinas.add(disciplinas);
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos.add(alunos);
    }
    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Curso: " + nome + "\nDisciplinas: \n" + disciplinas +"\nAlunos: \n" + alunos ;
    }
}
