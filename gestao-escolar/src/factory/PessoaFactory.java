package factory;

import models.Aluno;
import models.Pessoa;

public abstract class PessoaFactory{
    Pessoa pessoa;

    public Pessoa adicionar(String tipo) {
        if ("Aluno".equals(tipo)) {
            pessoa = criarPessoa(tipo);
        } else if ("Professor".equals(tipo)){
            pessoa = criarPessoa(tipo);
        }
        return pessoa;
    }
    public abstract Aluno criarPessoa(String tipo);
}
