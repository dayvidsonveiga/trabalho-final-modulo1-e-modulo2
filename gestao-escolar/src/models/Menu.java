package models;
import factory.PessoaFactory;
import factoryDisciplinaCurso.CursoDisciplinaFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Integer opcao;
    Boolean controle = true;

    static ArrayList<Curso> listaDeCursos = new ArrayList<>();
    static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void menuPrincipal(){
        while (controle) {
            System.out.println("##SEJA BEM VINDO A ESCOLA##");
            System.out.println("---------------------------");
            System.out.println("Digite 1 para acessar Portal do Aluno");
            System.out.println("Digite 2 para acessar Portal do Colaborador");
            System.out.println("Digite 0 para sair");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 0 -> {
                    controle = false;
                    break;
                }
                case 1 -> {
                    menuPortalDoAluno();
                }
                case 2 -> {
                    menuPortalDoColaborador();
                }
                default -> {
                    System.out.println("Opção inválida");
                }
            }
        }
    }
    public void menuPortalDoAluno() {
        System.out.println("Digite 1 para conferir as notas:");
        System.out.println("Digite 2 para voltar");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {}
            case 2 -> {
                menuPrincipal();

            }
        }

    }

    public void menuPortalDoColaborador() {
//        limpaTela();
        System.out.println("Digite 1 para acessar Área do Colaborador");
        System.out.println("Digite 2 Para acessar SysAdmin");
        System.out.println("Digite 3 para voltar");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {menuAreaDoColaborador();}
            case 2 -> {menuSysAdmin();}
            case 3 -> {}
        }
    }
    public void menuAreaDoColaborador() {
//        limpaTela();
        System.out.println("Digite 1 para conferir os últimos 3 pagamentos:");
        System.out.println("Digite 2 para voltar para o Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {}
            case 2 -> {
                menuPrincipal();

            }
        }
    }

    public void menuSysAdmin() {
//        limpaTela();
        System.out.println("Digite 1 para gerenciar alunos");
        System.out.println("Digite 2 para gerenciar colaboradores");
        System.out.println("Digite 3 para gerenciar curso");
        System.out.println("Digite 4 para voltar ao Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {
                menuGerenciarAlunos();
            }
            case 2 -> {
                menuGerenciarColaboradores();

            }
            case 3 -> {
                menuGerenciarCurso();
            }
            case 4 -> {
                menuPrincipal();
            }
        }
    }

    public void menuGerenciarAlunos() {
//        limpaTela();
        System.out.println("Digite 1 para adicionar um aluno");
        System.out.println("Digite 2 para atualizar as informações de um aluno");
        System.out.println("Digite 3 para remover um aluno");
        System.out.println("Digite 4 para acessar informações de um aluno");
        System.out.println("Digite 5 para voltar ao Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {
                Aluno aluno = PessoaFactory.criarAluno();

            }
            case 2 -> {
            }
            case 3 -> {
            }
            case 4 -> {}
            case 5 -> {
                menuPrincipal();
            }
        }
    }

    public void menuGerenciarColaboradores() {
//        limpaTela();
        System.out.println("Digite 1 para adicionar um colaborador");
        System.out.println("Digite 2 para atualizar as informações de um colaborador");
        System.out.println("Digite 3 para remover um colaborador");
        System.out.println("Digite 4 para acessar informações de um colaborador");
        System.out.println("Digite 5 para voltar ao Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {
                Colaborador colaborador = PessoaFactory.criarColaborador();
            }
            case 2 -> {
            }
            case 3 -> {
            }
            case 4 -> {}
            case 5 -> {
                menuPrincipal();
            }
        }
    }

    public void menuGerenciarCurso() {
//        limpaTela();
        System.out.println("Digite 1 para adicionar um curso");
        System.out.println("Digite 2 para atualizar as informações de um curso");
        System.out.println("Digite 3 para remover um curso");
        System.out.println("Digite 4 para acessar informações de um curso");
        System.out.println("Digite 5 para voltar ao Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {
                CursoDisciplinaFactory.criarCurso();
            }
            case 2 -> {
                CursoDisciplinaFactory.editarCurso();
            }
            case 3 -> {
                CursoDisciplinaFactory.removerCurso();
            }
            case 4 -> {
                menuGerenciarDisciplina();
            }
            case 5 -> {
                menuPrincipal();
            }
        }


    }

    public void menuGerenciarDisciplina() {
//        limpaTela();
        System.out.println("Digite 1 para adicionar uma disciplina");
        System.out.println("Digite 2 para atualizar as informações de uma disciplina");
        System.out.println("Digite 3 para remover uma disciplina");
        System.out.println("Digite 4 para acessar informações de uma disciplina");
        System.out.println("Digite 5 para voltar ao Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {
                CursoDisciplinaFactory.criarDisciplina();
            }
            case 2 -> {
                CursoDisciplinaFactory.editarDisciplina();
            }
            case 3 -> {
                CursoDisciplinaFactory.removerDisciplina();
            }
            case 4 -> {

            }
            case 5 -> {
                menuPrincipal();
            }
        }

    }
    public static ArrayList<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public static ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}

