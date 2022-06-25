package factory;

import models.Aluno;
import models.Endereco;
import models.Pessoa;

import java.util.Scanner;

public class CriarPessoa extends PessoaFactory{
    Scanner scanner = new Scanner(System.in);
    @Override
    public Aluno criarPessoa(String tipo) {
        Pessoa pessoa;
        if ("Aluno".equals(tipo)) {
            System.out.println("Digite o nome completo do Aluno:");
            Aluno aluno = new Aluno(scanner.nextLine());
            System.out.println("Digite o telefone do Aluno:");
            aluno.setTelefone(scanner.nextLine());
            System.out.println("Digite o E-mail do Aluno:");
            aluno.setEmail(scanner.nextLine());
            System.out.println("Digite o endereço do Aluno:");
            System.out.println("Logradouro:");
            aluno.setEndereco(new Endereco(scanner.nextLine()));
            System.out.println("Número:");
            aluno.getEndereco().setNumero(Integer.parseInt(scanner.nextLine()));
            System.out.println("Cidade:");
            aluno.getEndereco().setCidade(scanner.nextLine());
            System.out.println("Estado:");
            aluno.getEndereco().setEstado(scanner.nextLine());
            System.out.println("Cep:");
            aluno.getEndereco().setCep(scanner.nextLine());
            System.out.println("Curso:");

        }
        return null;
    }
}
