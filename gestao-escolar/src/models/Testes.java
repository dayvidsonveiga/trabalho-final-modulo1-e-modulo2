package models;

import java.util.ArrayList;
import java.util.Collections;

public class Testes {

    //disciplinas ensino médio
    public static void teste () {
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
        ArrayList<Disciplina> ensinoMedio = new ArrayList<>();
        Collections.addAll(ensinoMedio, portugues, matematica, geografia, historia, fisica, quimica, filosofia);
        Curso ensinoMedioCurso = new Curso("Ensino Médio");
        ensinoMedioCurso.setDisciplinas(ensinoMedio);

        //disciplinas direito
        Disciplina introDireito = new Disciplina();
        introDireito.setNome("Introdução ao Direito");
        Disciplina direitoPenal = new Disciplina();
        direitoPenal.setNome("Direito Penal");
        Disciplina direitoConstitucional = new Disciplina();
        direitoConstitucional.setNome("Direito Constitucional");
        Disciplina direitoPrevidenciario = new Disciplina();
        direitoPrevidenciario.setNome("Direito Previdenciario");
        ArrayList<Disciplina> direito = new ArrayList<>();
        Collections.addAll(direito, introDireito, direitoPenal, direitoConstitucional, direitoPrevidenciario);
        Curso direitoCurso = new Curso("Direito");
        direitoCurso.setDisciplinas(direito);

        //disciplinas ciência da computação
        Disciplina introAComputacao = new Disciplina();
        introAComputacao.setNome("Introdução a computação");
        Disciplina engDeSoftware = new Disciplina();
        engDeSoftware.setNome("Engenharia de Software");
        Disciplina processoDeSoftware = new Disciplina();
        processoDeSoftware.setNome("Processo de Software");
        Disciplina arquiteturaDeSistemas = new Disciplina();
        arquiteturaDeSistemas.setNome("Arquitetura de Sistemas");
        ArrayList<Disciplina> cienciaDaComputacao = new ArrayList<>();
        Collections.addAll(cienciaDaComputacao, introAComputacao, engDeSoftware, processoDeSoftware, arquiteturaDeSistemas);
        Curso cienciaDaComputacaoCurso = new Curso("Ciência da computação");
        cienciaDaComputacaoCurso.setDisciplinas(cienciaDaComputacao);


        //endereços
        Endereco endereco1 = new Endereco("Rua das Camélias", "Canoas", "RS", "95280-950", 52);
        Endereco endereco2 = new Endereco("Rua Araçá", "Canoas", "RS", "95560-090", 396);
        Endereco endereco3 = new Endereco("Rua Duque de Caxias", "Porto Alegre", "RS", "93285-365", 590);
        Endereco endereco4 = new Endereco("Rua Demétrio Ribeiro", "Porto Alegre", "RS", "93274-150", 1000);

        //alunos
        Aluno aluno1 = new Aluno("João Torres", "98667412", "joao@torres.com", endereco1, direitoCurso);
        Aluno aluno2 = new Aluno("Roberta Vaz", "33459699", "roberta@vaz.com", endereco2, cienciaDaComputacaoCurso);

        //professores
        Colaborador colaborador1 = new Colaborador("Marina Ribeiro", "985923366", "marina@ribeiro.com", endereco3, 9600.00, "Professora");


        Colaborador colaborador2 = new Colaborador("Rodrigo Pereira", "98659916", "rodrigo@pereira.com", endereco4, 8000.00, "Professor");

        Menu.getListaDeCursos().add(cienciaDaComputacaoCurso);
        Menu.getListaDeCursos().add(direitoCurso);
        Menu.getListaDeCursos().add(ensinoMedioCurso);
        Menu.getListaDeCursos().get(0).setAlunos(aluno1);
        Menu.getListaDeCursos().get(1).setAlunos(aluno2);

        for (int i = 0; i < ensinoMedio.size(); i++) {
            Menu.getListaDeDisciplinas().add(ensinoMedio.get(i));
        }
        for (int i = 0; i < direito.size(); i++) {
            Menu.getListaDeDisciplinas().add(direito.get(i));
        }
        for (int i = 0; i < cienciaDaComputacao.size(); i++) {
            Menu.getListaDeDisciplinas().add(cienciaDaComputacao.get(i));
        }

        portugues.setProfessor(colaborador1);
        matematica.setProfessor(colaborador2);

        ArrayList<Double> notas1 = new ArrayList<>();
        notas1.add(9.0);
        notas1.add(7.0);

        Menu.getListaDeCursos().get(0).getAlunos().get(0).setNotas("Introdução a computação", notas1);
        ArrayList<Double> notas2 = new ArrayList<>();
        notas2.add(5.0);
        notas2.add(8.0);
        Menu.getListaDeCursos().get(1).getAlunos().get(0).setNotas("Introdução ao Direito", notas2);
    }
}
