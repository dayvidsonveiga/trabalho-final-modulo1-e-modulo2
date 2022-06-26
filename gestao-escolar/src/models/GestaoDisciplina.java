package models;

import interfaces.Gestao;

import java.util.Scanner;

public class GestaoDisciplina implements Gestao {

    Scanner scanner = new Scanner(System.in);


    @Override
    public void editar() {
        System.out.println("Qual disciplina deseja editar?");
        for (int i = 0; i < Menu.getListaDeDisciplinas().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeDisciplinas().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o novo nome para a disciplina");
        String novoNomeDaDisciplina = scanner.nextLine();
        Menu.getListaDeDisciplinas().get(opcao -1 ).setNome(novoNomeDaDisciplina);
    }

    @Override
    public void remover() {
        System.out.println("Qual disciplina deseja remover?");
        for (int i = 0; i < Menu.getListaDeDisciplinas().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeDisciplinas().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        Menu.getListaDeDisciplinas().remove(opcao - 1);
    }
}
