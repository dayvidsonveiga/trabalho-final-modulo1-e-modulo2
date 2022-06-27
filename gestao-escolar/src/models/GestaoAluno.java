package models;

import interfaces.Gestao;
import interfaces.Portal;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoAluno implements Gestao, Portal {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void editar() {
        Boolean controle = false;
        Integer indexAluno = 0;
        System.out.println("Qual o curso do aluno que deseja editar?");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());

        }
        Integer escolhaCurso = Integer.parseInt(scanner.nextLine());
        System.out.println("Qual a matricula do aluno que deseja editar");
        for (int j = 0; j < Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().size(); j++) {
            System.out.println(Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(j));
        }
        Integer escolhaMatricula = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().size(); i++) {
            if (Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(i).getMatricula().equals(escolhaMatricula)) {
                controle = true;
                indexAluno = i;
            } else {
                controle = false;
            }
        }

        if (controle) {
            Aluno alunoEscolhido = Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(indexAluno);
            System.out.println("Digite o nome completo do Aluno:");
            alunoEscolhido.setNome(scanner.nextLine());
            System.out.println("Digite o telefone do Aluno:");
            alunoEscolhido.setTelefone(scanner.nextLine());
            System.out.println("Digite o E-mail do Aluno:");
            alunoEscolhido.setEmail(scanner.nextLine());
            System.out.println("Digite o endereço do Aluno:");
            System.out.println("Logradouro:");
            alunoEscolhido.getEndereco().setLogradouro(scanner.nextLine());
            System.out.println("Número:");
            alunoEscolhido.getEndereco().setNumero(Integer.parseInt(scanner.nextLine()));
            System.out.println("Cidade:");
            alunoEscolhido.getEndereco().setCidade(scanner.nextLine());
            System.out.println("Estado:");
            alunoEscolhido.getEndereco().setEstado(scanner.nextLine());
            System.out.println("Cep:");
            alunoEscolhido.getEndereco().setCep(scanner.nextLine());
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    @Override
    public void remover() {
        Boolean controle = false;
        int indexAluno = 0;
        System.out.println("Qual o curso do aluno que deseja remover?");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        Integer escolhaCurso = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe a matricula do aluno que deseja remover:");
        for (int j = 0; j < Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().size(); j++) {
            System.out.println(Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(j));
        }
        Integer escolhaMatricula = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().size(); i++) {
            if (Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(i).getMatricula().equals(escolhaMatricula)) {
                controle = true;
                indexAluno = i;
            } else {
                controle = false;
            }
        }
        if (controle) {
            Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().remove(indexAluno);
            System.out.println("Aluno removido");
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void darNota(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o curso:");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
                System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        System.out.println("Escolha o aluno: ");
        for (int i = 0; i < Menu.getListaDeCursos().get(opcao - 1).getAlunos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(opcao - 1).getAlunos().get(i));
        }
        Integer opcao2 = Integer.parseInt(scanner.nextLine());
        darNotaAux(opcao, opcao2);
    }

    private void darNotaAux(Integer opcao, Integer opcao2) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> disciplinas = new ArrayList<>();
        ArrayList<Double> notas = new ArrayList<>();
        for (int i = 0; i < Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().size() ; i++) {
            disciplinas.add(Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().get(i).getNome());
        }
        System.out.println("Escolha a disciplina:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + " - " + disciplinas.get(i));
        }
        Integer opcao3 = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe a nota N1:");
        notas.add(Double.parseDouble(scanner.nextLine()));
        System.out.println("Informe a nota N2:");
        notas.add(Double.parseDouble(scanner.nextLine()));
        Menu.getListaDeCursos().get(opcao - 1).getAlunos().get(opcao2 -1).getNotas().put(disciplinas.get(opcao3), notas);
        System.out.println("Cadastrar notas de outra disciplina:");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        Integer opcao4 = Integer.parseInt(scanner.nextLine());
        if (opcao4.equals(1)) {
            darNotaAux(opcao, opcao2);
        } else {
            System.out.println("Notas adicionadas");
        }
    }

    @Override
    public void imprimirInformacoes() {
        Boolean controle = false;
        int indexAluno = 0;
        System.out.println("Escolha seu curso:");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        Integer escolhaCurso = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe a matricula:");
        for (int j = 0; j < Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().size(); j++) {
            System.out.println(Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(j));
        }
        Integer escolhaMatricula = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().size(); i++) {
            if (Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(i).getMatricula().equals(escolhaMatricula)) {
                controle = true;
                indexAluno = i;
            } else {
                controle = false;
            }
        }
        if (controle) {
            Menu.getListaDeCursos().get(escolhaCurso - 1).getAlunos().get(indexAluno).getNotasImprimir();
        } else {
            System.out.println("Matrícula não encontrada");
        }
    }
}






