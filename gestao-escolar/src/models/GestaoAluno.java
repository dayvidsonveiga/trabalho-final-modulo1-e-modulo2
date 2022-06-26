package models;

import interfaces.Gestao;

import java.util.Scanner;

public class GestaoAluno implements Gestao {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void editar() {
        System.out.println("Qual a matricula do aluno que deseja editar? \n1 - Informar matrícula \n2 - Consultar matrícula para depois informar");
        Integer matriculaAluno = Integer.parseInt(scanner.nextLine());
        switch (matriculaAluno) {
            case 1 -> {

            }
            case 2 -> {
                for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
                    System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getAlunos().get(i).getNome());
                }
            }
        }
        System.out.println("Informe a matricula");
        Integer opcao = Integer.parseInt(scanner.nextLine());

    }

    @Override
    public void remover() {

    }
}
