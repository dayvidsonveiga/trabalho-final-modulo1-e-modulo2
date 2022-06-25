package models;

public class Colaborador extends Pessoa{
    private Double salario;
    private Curso curso;
    private String cargo;

    public Colaborador(Double salario, Curso curso, String cargo) {
        this.salario = salario;
        this.curso = curso;
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
