//package service;
//
//import models.Disciplina;
//import view.Menu;
//
//import java.util.Scanner;
//
//public class GestaoCurso implements Gestao {
//    Scanner scanner = new Scanner(System.in);
//
//    @Override
//    public void editar() {
//        System.out.println("Qual curso deseja editar?");
//        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
//            System.out.println((i + 1) + " - " + Menu.listaDeCursos.get(i).getNome());
//        }
//        Integer opcao = Integer.parseInt(scanner.nextLine());
//        System.out.println("Informe o novo nome para o curso");
//        String novoNomeDoCurso = scanner.nextLine();
//        Menu.getListaDeCursos().get(opcao -1 ).setNome(novoNomeDoCurso);
//    }
//
//    @Override
//    public void remover() {
//        System.out.println("Qual disciplina curso deseja remover?");
//        for (int j = 0; j < Menu.getListaDeCursos().size(); j++) {
//            System.out.println((j + 1) + " - " + Menu.getListaDeCursos().get(j).getNome());
//        }
//        Integer opcao = Integer.parseInt(scanner.nextLine());
//        Menu.getListaDeCursos().remove(opcao - 1);
//        System.out.println("Curso removido");
//    }
//
//    public void imprimirInformacoesDoCurso() {
//        Integer opcao = 0;
//        System.out.println("Escolha o curso");
//        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
//            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
//        }
//        opcao = Integer.parseInt(scanner.nextLine());
//        System.out.println(Menu.getListaDeCursos().get(opcao - 1));
//    }
//
//    public void inserirDisciplinaNoCurso() {
//        int adicionarDisciplinaNoCurso;
//        int indexCursoDaDisciplina = 0, indexDisciplinaNoCurso = 0;
//        System.out.println("Adicionar disciplina ao curso:");
//        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
//            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
//        }
//        indexCursoDaDisciplina = Integer.parseInt(scanner.nextLine());
//        System.out.println("Escolha a disciplina:");
//        for (int i = 0; i < Menu.getListaDeDisciplinas().size(); i++) {
//            System.out.println((i + 1) + " - " + Menu.getListaDeDisciplinas().get(i).getNome());
//        }
//        int indexDisciplina = Integer.parseInt(scanner.nextLine());
//        Disciplina adicionarDisciplina = Menu.getListaDeDisciplinas().get(indexDisciplina - 1);
//        Boolean controle = false;
//
//        for (int i = 0; i < Menu.getListaDeCursos().get(indexCursoDaDisciplina - 1).getDisciplinas().size(); i++) {
//            if (Menu.getListaDeCursos().get(indexCursoDaDisciplina - 1).getDisciplinas().get(i).equals(Menu.getListaDeDisciplinas().get(indexDisciplina - 1))) {
//                controle = true;
//            }
//        }
//        if (!controle) {
//            Menu.getListaDeCursos().get(indexCursoDaDisciplina - 1).setDisciplinas(adicionarDisciplina);
//            System.out.println("Disciplina adicionada");
//        } else {
//            System.out.println("Esta disciplina já existe no curso");
//        }
//    }
//}
//
