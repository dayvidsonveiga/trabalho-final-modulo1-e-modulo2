package models;

import interfaces.Gestao;
import interfaces.Portal;

import java.util.Scanner;

public class GestaoCurso implements Gestao {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void editar() {
        System.out.println("Qual curso deseja editar?");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.listaDeCursos.get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o novo nome para o curso");
        String novoNomeDoCurso = scanner.nextLine();
        Menu.getListaDeCursos().get(opcao -1 ).setNome(novoNomeDoCurso);
    }

    @Override
    public void remover() {
        System.out.println("Qual disciplina curso deseja remover?");
        for (int j = 0; j < Menu.getListaDeCursos().size(); j++) {
            System.out.println((j + 1) + " - " + Menu.getListaDeCursos().get(j).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        Menu.getListaDeCursos().remove(opcao - 1);
        System.out.println("Curso removido");
    }

    public void imprimirInformacoesDoCurso() {
        Integer opcao = 0;
        System.out.println("Escolha o curso");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        opcao = Integer.parseInt(scanner.nextLine());
        System.out.println(Menu.getListaDeCursos().get(opcao - 1));
    }

    public void inserirDisciplinaNoCurso(){


        System.out.println("Escolha o curso: \n");
        for (int j = 0; j < Menu.getListaDeCursos().size(); j++) {
            System.out.println((j + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        opcao = Integer.parseInt(scanner.nextLine());
        armazenarDisciplina(disciplinaNova);
        Menu.getListaDeCursos().get(opcao - 1).setDisciplinas(disciplinaNova);
    }
}
