package factoryDisciplinaCurso;

import models.Aluno;
import models.Curso;
import models.Disciplina;
import models.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CursoDisciplinaFactory {
    static Scanner scanner = new Scanner(System.in);

    public Curso ensinoMedio(String nomeDoCurso) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Curso ensinoMedio = new Curso(nomeDoCurso);
        CriarDisciplina criarDisciplina = new CriarDisciplina();

        ensinoMedio.setDisciplinas(criarDisciplina.criarDisciplina(nomeDoCurso));
        ensinoMedio.setAlunos(alunos);
        return ensinoMedio;
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

    public static void armazenarDisciplina(Disciplina nomeDaDisciplina) {
        for (int i = 0; i < Menu.getDisciplinas().size(); i++) {
            if (Menu.getDisciplinas().get(i).getNome() == nomeDaDisciplina.getNome()) {
                System.out.println("Esta disciplina já existe");
            } else {
                Menu.getDisciplinas().add(nomeDaDisciplina);
            }
        }
    }
}
