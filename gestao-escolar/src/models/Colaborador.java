package models;

public class Colaborador extends Pessoa{
    private Double salario;
    private String cargo;

    public Colaborador(String nome) {
        super(nome);
    }

    public Colaborador(String nome, String telefone, String email, Endereco endereco, Double salario, String cargo) {
        super(nome, telefone, email, endereco);
        this.salario = salario;
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
