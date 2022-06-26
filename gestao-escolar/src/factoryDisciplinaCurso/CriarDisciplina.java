package factoryDisciplinaCurso;

import models.Disciplina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CriarDisciplina {
    ArrayList<Disciplina> ensinoMedio = new ArrayList<>();
    public ArrayList<Disciplina> criarDisciplina(String curso){

        if ("Ensino Médio".equals(curso)) {
            Disciplina portugues = new Disciplina();
            portugues.setNome("Português");
            Disciplina matematica = new Disciplina();
            matematica.setNome("Matemática");
            Disciplina geografia = new Disciplina();
            geografia.setNome("Geografia");
            Disciplina historia = new Disciplina();
            historia.setNome("História");
            Disciplina fisica = new Disciplina();
            fisica.setNome("Física");
            Disciplina quimica = new Disciplina();
            quimica.setNome("Química");
            Disciplina filosofia = new Disciplina();
            filosofia.setNome("Filosofia");
            Collections.addAll(ensinoMedio, portugues, matematica, geografia, historia, fisica, quimica, filosofia);
            return ensinoMedio;
        } else {
            String nomeDoCurso;
            Integer quantidadeDeMaterias;
            ArrayList<Disciplina> novoCurso = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nome do curso:");
            nomeDoCurso = scanner.nextLine();
            System.out.println("Adicionar quantas disciplinas");
            quantidadeDeMaterias = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < quantidadeDeMaterias; i++) {
                System.out.println("Nome da " + i + "° matéria:");
            }
            return novoCurso;
        }
    }
}
