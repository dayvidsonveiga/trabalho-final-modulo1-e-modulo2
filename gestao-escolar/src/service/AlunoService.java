package service;

import models.Aluno;
import repository.AlunoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AlunoService {
    AlunoRepository alunoRepository;

    public AlunoService() {
        alunoRepository = new AlunoRepository();
    }

    public void adicionarAluno(Aluno aluno) {
        try {
            alunoRepository.adicionar(aluno);
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public void editarAluno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ID do aluno que deseja atualizar dados: ");

        int controleNome = 0;
        int controleTelefone = 0;
        int controleEmail = 0;
        Integer escolhaAluno = 0;
        listarAlunos();
        escolhaAluno = Integer.parseInt(scanner.nextLine());
        Aluno alunoEscolhido = listarAlunos().get(escolhaAluno);

        try {
            System.out.println("Atualizar nome do aluno? [1 - Sim / 2 - Não]");
            controleNome = Integer.parseInt(scanner.nextLine());
            if (controleNome == 1) {
                System.out.println("Informe o novo Nome da Disciplina: ");
                alunoEscolhido.setNome(scanner.nextLine());
            } else {
                System.out.println("Nome atual da disciplina: " + alunoEscolhido.getNome());
            }

            System.out.println("Atualizar o telefone do aluno? [1 - Sim / 2 - Não]");
            controleTelefone = Integer.parseInt(scanner.nextLine());
                if (controleTelefone == 1) {
                    System.out.println("Informe o novo número de telefone: ");
                    alunoEscolhido.setTelefone(scanner.nextLine());
                } else {
                    System.out.println("Número de telefone atual: " + alunoEscolhido.getTelefone());
                }

            System.out.println("Atualizar o e-mail do aluno? [1 - Sim / 2 - Não]");
            controleEmail = Integer.parseInt(scanner.nextLine());
            if (controleEmail == 1) {
                System.out.println("Informe o novo e-mail: ");
                alunoEscolhido.setEmail(scanner.nextLine());
            } else {
                System.out.println("E-mail atual: " + alunoEscolhido.getEmail());
            }
                alunoRepository.editar(alunoEscolhido.getIdAluno(), alunoEscolhido);
            } catch (SQLException e) {
            e.getCause();
            }
    }

    public void removerAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual aluno deseja remover?");
        List<Aluno> alunos = this.listarAlunos();
        int opcao = (Integer.parseInt(scanner.nextLine())) - 1;
        try {
            Integer idEndereco = alunos.get(opcao).getEndereco().getIdEndereco();
            alunoRepository.remover(alunos.get(opcao).getIdAluno());
            EnderecoService enderecoService = new EnderecoService();
            enderecoService.removerEndereco(idEndereco);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarAlunos() {
        try {
            List<Aluno> listar = alunoRepository.listar();
            listar.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    }

