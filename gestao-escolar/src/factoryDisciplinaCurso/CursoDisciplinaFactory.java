package factoryDisciplinaCurso;

import models.Aluno;
import models.Curso;
import models.Disciplina;
import models.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoDisciplinaFactory {
    static Scanner scanner = new Scanner(System.in);

    public static void criarCurso(String nomeDoCurso) {
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
        }else {Menu.getListaDeCursos().add(novoCurso);
        }
    }

    public static void editarCurso(){
        System.out.println("Qual curso deseja editar?");
        for (int i = 0; i < Menu.getListaDeCursos().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getDisciplinas().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o novo nome para o curso");
        String novoNomeDoCurso = scanner.nextLine();
        Menu.getListaDeCursos().get(opcao -1 ).setNome(novoNomeDoCurso);
    }

    public static void criarDisciplina() {
        Integer quantidadeDeMaterias;
        System.out.println("Adicionar quantas disciplinas");
        quantidadeDeMaterias = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < quantidadeDeMaterias; i++) {
            System.out.println("Nome da " + i + "° matéria:");
            String nomeDaDisciplina = scanner.nextLine();
            Disciplina disciplinaNova = new Disciplina();
            disciplinaNova.setNome(nomeDaDisciplina);
            System.out.println("Deseja adicionar esta disciplina à um curso?\n1- Sim\n 2-Não");
            Integer opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> {
                    System.out.println("Escolha o curso: \n");
                    for (int j = 0; j < Menu.getListaDeCursos().size(); j++) {
                        System.out.println((j + 1) + " - " + Menu.getDisciplinas().get(i).getNome());
                    }
                    opcao = Integer.parseInt(scanner.nextLine());
                    armazenarDisciplina(disciplinaNova);
                    Menu.getListaDeCursos().get(opcao - 1).setDisciplinas(disciplinaNova);
                }
                case 2 -> {
                    armazenarDisciplina(disciplinaNova);
                }
            }
        }
    }

    public static void editarDisciplina(){
        System.out.println("Qual disciplina deseja editar?");
        for (int i = 0; i < Menu.getDisciplinas().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getDisciplinas().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o novo nome para a disciplina");
        String novoNomeDaDisciplina = scanner.nextLine();
        Menu.getDisciplinas().get(opcao -1 ).setNome(novoNomeDaDisciplina);
    }

    public static void removerDisciplina(){
        System.out.println("Qual disciplina deseja remover?");
        for (int i = 0; i < Menu.getDisciplinas().size(); i++) {
            System.out.println((i + 1) + " - " + Menu.getDisciplinas().get(i).getNome());
        }
        Integer opcao = Integer.parseInt(scanner.nextLine());
        Menu.getDisciplinas().remove(opcao - 1);
    }


    public static void armazenarDisciplina(Disciplina nomeDaDisciplina) {
        Boolean contem = false;
        for (int i = 0; i < Menu.getDisciplinas().size(); i++) {
            if (Menu.getDisciplinas().get(i).getNome().equalsIgnoreCase(nomeDaDisciplina.getNome())) {
                contem = true;
            } else {
                contem = false;
            }
            if (contem) {
                System.out.println("Esta disciplina já existe");
            }else {Menu.getDisciplinas().add(nomeDaDisciplina);
            }

        }
    }
}
