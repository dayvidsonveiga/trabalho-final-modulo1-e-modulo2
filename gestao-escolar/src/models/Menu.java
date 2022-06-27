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
    static ArrayList<Disciplina> listaDeDisciplinas = new ArrayList<>();
    GestaoCurso gestaoCurso = new GestaoCurso();
    GestaoDisciplina gestaoDisciplina = new GestaoDisciplina();
    GestaoAluno gestaoAluno = new GestaoAluno();


    public void menuPrincipal(){
        while (controle) {
            System.out.println("##SEJA BEM VINDO A ESCOLA##");
            System.out.println("---------------------------");
            System.out.println("Digite 1 para acessar Portal do Aluno");
            System.out.println("Digite 2 para acessar Portal do Professor");
            System.out.println("Digite 3 para acessar Portal de Gestão");
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
                    menuAreaDoProfessor();
                }
                case 3 -> {
                    menuAreaDeGestao();
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
            case 1 -> {
                gestaoAluno.imprimirInformacoes();

            }
            case 2 -> {
                menuPrincipal();

            }
            default -> {
                menuPortalDoAluno();
            }
        }

    }

    public void menuAreaDoProfessor() {
//        limpaTela();
        System.out.println("Digite 1 para adicionar ou editar notas de alunos:");
        System.out.println("Digite 2 para voltar para o Menu Principal");
        System.out.println("Digite 0 para sair");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 0 -> {
                controle = false;
                break;
            }
            case 1 -> {
                gestaoAluno.darNota();
            }
            case 2 -> {
                menuPrincipal();
            }
            default -> {
                menuAreaDoProfessor();
            }
        }
    }

    public void menuAreaDeGestao() {
//        limpaTela();
        System.out.println("Digite 1 para gerenciar alunos");
        System.out.println("Digite 2 para gerenciar colaboradores");
        System.out.println("Digite 3 para gerenciar curso");
        System.out.println("Digite 4 para gerenciar disciplina");
        System.out.println("Digite 5 para voltar ao Menu Principal");
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
                menuGerenciarDisciplina();
            }
            case 5 -> {
                menuPrincipal();
            }
            default -> {
                menuAreaDeGestao();
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
                PessoaFactory.criarAluno();
            }
            case 2 -> {
                gestaoAluno.editar();
            }
            case 3 -> {
                gestaoAluno.remover();
            }
            case 4 -> {
                gestaoAluno.imprimirInformacoes();
            }
            case 5 -> {
                menuPrincipal();
            }
            default -> {
                menuPortalDoAluno();
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
                PessoaFactory.criarColaborador();
            }
            case 2 -> {
                System.out.println("Em construção");

            }
            case 3 -> {
                System.out.println("Em construção");

            }
            case 4 -> {
                System.out.println("Em construção");

            }
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
        System.out.println("Digite 5 para adicionar uma disciplina à um curso");
        System.out.println("Digite 6 para voltar ao Menu Principal");
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
                gestaoCurso.editar();
            }
            case 3 -> {
                gestaoCurso.remover();
            }
            case 4 -> {
                gestaoCurso.imprimirInformacoesDoCurso();
            }
            case 5 -> {
                gestaoCurso.inserirDisciplinaNoCurso();
            }
            case 6 -> {
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
                gestaoDisciplina.editar();
            }
            case 3 -> {
                gestaoDisciplina.remover();
            }
            case 4 -> {
                gestaoDisciplina.imprimirInformacoes();
            }
            case 5 -> {
                menuPrincipal();
            }
        }

    }
    public static ArrayList<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public static ArrayList<Disciplina> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }
}

