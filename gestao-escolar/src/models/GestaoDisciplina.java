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

        Boolean controle = false;
        int indexDisciplinaNoCurso = 0, indexCursoDaDisciplina = 0;
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            for (int j = 0; j < Menu.getListaDeCursos().get(i).getDisciplinas().size(); j++) {
                if (Menu.getListaDeCursos().get(i).getDisciplinas().get(j).equals(Menu.getListaDeDisciplinas().get(opcao - 1))) {
                    controle = true;
                    indexCursoDaDisciplina = i;
                    indexDisciplinaNoCurso = j;
                }
                }
            if (controle) {
                Menu.getListaDeCursos().get(indexCursoDaDisciplina).getDisciplinas().remove(indexDisciplinaNoCurso);
            }
        }
        Menu.getListaDeDisciplinas().remove(opcao - 1);
    }

    public void imprimirInformacoes(){
        Integer opcao = 0;
        System.out.println("Escolha o curso");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getListaDeCursos().get(i).getNome());
        }
        opcao = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().size(); i++) {
            System.out.println("Disciplina: " + Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().get(i));
            System.out.println("Professor: " + Menu.getListaDeCursos().get(opcao - 1).getDisciplinas().get(i).getProfessor());
        }
    }
}
