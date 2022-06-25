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
            portugues.setCurso("Ensino Médio");
            portugues.setNome("Português");
            Disciplina matematica = new Disciplina();
            matematica.setCurso("Ensino Médio");
            matematica.setNome("Matemática");
            Disciplina geografia = new Disciplina();
            geografia.setCurso("Ensino Médio");
            geografia.setNome("Geografia");
            Disciplina historia = new Disciplina();
            historia.setCurso("Ensino Médio");
            historia.setNome("História");
            Disciplina fisica = new Disciplina();
            fisica.setCurso("Ensino Médio");
            fisica.setNome("Física");
            Disciplina quimica = new Disciplina();
            quimica.setNome("Química");
            quimica.setCurso("Ensino Médio");
            Disciplina filosofia = new Disciplina();
            filosofia.setCurso("Ensino Médio");
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
            System.out.println("Quantas matérias o curso possui?");
            quantidadeDeMaterias = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < quantidadeDeMaterias; i++) {
                System.out.println("Nome da " + i + "° matéria:");
                novoCurso.add(new Disciplina());
                novoCurso.get(i).setNome(scanner.nextLine());
                novoCurso.get(i).setCurso(nomeDoCurso);
            }
            return novoCurso;
        }
    }
}
