package factory;

import models.Aluno;
import models.Pessoa;

public abstract class PessoaFactory{
    Pessoa pessoa;
    Aluno pessoaAluno;

    public void adicionar(String tipo) {
        if ("Aluno".equals(tipo)) {
            pessoaAluno = criarPessoa(tipo);
            pessoaAluno.getCurso().setAlunos(pessoaAluno);
        } else if ("Professor".equals(tipo)){
            pessoa = criarPessoa(tipo);
        }
        System.out.println(pessoaAluno.getCurso().getDisciplinas());
    }
    public abstract Aluno criarPessoa(String tipo);
}
