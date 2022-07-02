package service.factory;

import models.Aluno;
import models.Curso;
import models.Disciplina;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoDisciplinaFactory {
    static Scanner scanner = new Scanner(System.in);

    public static void criarCurso() {
        System.out.println("Informe o nome do novo curso:");
        String nomeDoCurso = scanner.nextLine();
        Boolean contem = false;
        Curso novoCurso = new Curso(nomeDoCurso);
        ArrayList<Disciplina> disciplinaArrayList = new ArrayList<>();
        novoCurso.setDisciplinas(disciplinaArrayList);
        ArrayList<Aluno> alunoArrayList = new ArrayList<>();
        novoCurso.setAlunos(alunoArrayList);
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            if (Menu.getListaDeCursos().get(i).getNome().equalsIgnoreCase(novoCurso.getNome())) {
                contem = true;
            } else {
                contem = false;
            }
        }
        if (contem) {
            System.out.println("Este curso já existe");
        } else {
            Menu.getListaDeCursos().add(novoCurso);
            System.out.println("Curso adicionado");
        }
    }

    public static Disciplina criarDisciplina() {
        Boolean contem = false;

        System.out.println("Digite o nome da nova Disciplina: ");
        String nomeDaDisciplina = scanner.nextLine();
        Disciplina disciplinaNova = new Disciplina();
        disciplinaNova.setNome(nomeDaDisciplina);

        return disciplinaNova;
    }

    public static void armazenarDisciplina(Disciplina nomeDaDisciplina) {
        Boolean contem = false;
        for (int i = 0; i < Menu.getListaDeDisciplinas().size(); i++) {
            if (Menu.getListaDeDisciplinas().get(i).getNome().equalsIgnoreCase(nomeDaDisciplina.getNome())) {
                contem = true;
            } else {
                contem = false;
            }
        }
        if (contem) {
            System.out.println("Esta disciplina já existe");
        }else {Menu.getListaDeDisciplinas().add(nomeDaDisciplina);
        }
    }

//    public static void adicionarDisciplinaCurso(Disciplina disciplina, Curso curso) {
//        System.out.println("Deseja adicionar esta disciplina à um curso?\n1 - Sim\n2 - Não");
//        Integer opcao = Integer.parseInt(scanner.nextLine());
//        switch (opcao) {
//            case 1 -> {
//                System.out.println("Escolha o curso: \n");
//                for (int j = 0; j < Menu.getListaDeCursos().size(); j++) {
//                    System.out.println((j + 1) + " - " + Menu.getListaDeCursos().get(j).getNome());
//                }
//                opcao = Integer.parseInt(scanner.nextLine());
//                armazenarDisciplina(disciplinaNova);
//                Menu.getListaDeCursos().get(opcao - 1).setDisciplinas(disciplinaNova);
//            }
//            case 2 -> {
//                armazenarDisciplina(disciplinaNova);
//            }default -> {
//                System.out.println("Opção inválida");
//            }
//        }
//    }
}
