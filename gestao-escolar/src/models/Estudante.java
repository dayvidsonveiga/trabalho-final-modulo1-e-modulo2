package models;

public class Estudante extends Pessoa{
    private Integer matricula, tipo;
    private Curso curso;

    public Estudante(String nome, String telefone, String email, Endereco endereco, Integer matricula, Integer tipo, Curso curso) {
        super(nome, telefone, email, endereco);
        this.matricula = matricula;
        this.tipo = tipo;
        this.curso = curso;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
