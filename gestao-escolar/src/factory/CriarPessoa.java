package factory;

import factoryDisciplinaCurso.CriarCurso;
import models.Aluno;
import models.Colaborador;
import models.Endereco;
import models.Pessoa;

import java.util.Scanner;

public class CriarPessoa extends PessoaFactory{
    Scanner scanner = new Scanner(System.in);
    @Override
    public Aluno criarPessoa(String tipo) {
        Pessoa pessoa;
        if ("Aluno".equals(tipo)) {
            String curso;
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
            curso = scanner.nextLine();
            CriarCurso criarCurso = new CriarCurso();
            aluno.setCurso(criarCurso.criarCurso(curso));
            return aluno;

        } else if ("Professor".equals(tipo)) {
            System.out.println("Digite o nome do colaborador:");
            Colaborador colaborador = new Colaborador(scanner.nextLine());
            System.out.println("Digite o telefone do Colaborador:");
            colaborador.setTelefone(scanner.nextLine());
            System.out.println("Digite o E-mail do Colaborador:");
            colaborador.setEmail(scanner.nextLine());
            System.out.println("Digite o cargo do Colaborador:");
            colaborador.setCargo(scanner.nextLine());
            System.out.println("Digite o salário do colaborador:");
            System.out.print("R$");
            colaborador.setSalario(Double.parseDouble(scanner.nextLine()));
            System.out.println("Digite o endereço do Colaborador:");
            System.out.println("Logradouro:");
            colaborador.setEndereco(new Endereco(scanner.nextLine()));
            System.out.println("Número:");
            colaborador.getEndereco().setNumero(Integer.parseInt(scanner.nextLine()));
            System.out.println("Cidade:");
            colaborador.getEndereco().setCidade(scanner.nextLine());
            System.out.println("Estado:");
            colaborador.getEndereco().setEstado(scanner.nextLine());
            System.out.println("Cep:");
            colaborador.getEndereco().setCep(scanner.nextLine());
        }
        return null;
    }
}
