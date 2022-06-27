package factory;

import models.Aluno;
import models.Colaborador;
import models.Endereco;
import models.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class PessoaFactory {
    static Scanner scanner = new Scanner(System.in);

    public static void criarAluno() {
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
        System.out.println("Escolha o curso do aluno: ");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        Menu.getListaDeCursos().get(opcao - 1).setAlunos(aluno);
        ArrayList<Double> notas = new ArrayList<Double>();
        notas.add(0.0);
        notas.add(0.0);
        for (int i = 0; i < Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().size(); i++) {
            aluno.setNotas(Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().get(i).getNome(), notas);
        }
        System.out.println("Aluno cadastrado");
    }
    public static void criarColaborador() {
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
        for (int i = 0; i < Menu.getListaDeDisciplinas().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeDisciplinas().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        Menu.getListaDeDisciplinas().get(opcao - 1).setProfessor(colaborador);
        Menu.getListaDeColaboradores().add(colaborador);
    }
}
