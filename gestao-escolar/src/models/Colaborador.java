package models;

public class Colaborador extends Pessoa{
    private Double salario;
    private Curso curso;
    private String cargo;

    public Colaborador(String nome, String telefone, String email, Endereco endereco, Double salario, Curso curso, String cargo) {
        super(nome, telefone, email, endereco);
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
