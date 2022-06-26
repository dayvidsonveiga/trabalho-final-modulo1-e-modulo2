package models;

import java.util.ArrayList;
import java.util.Collections;

public class Testes {

    //disciplinas ensino médio
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

    //disciplinas direito
    Disciplina introDireito = new Disciplina();
    introDireito.setNome("Introduçãoa ao Direito");
    Disciplina direitoPenal = new Disciplina();
    direitoPenal.setNome("Direito Penal");
    Disciplina direitoConstitucional = new Disciplina();
    direitoConstitucional.setNome("Direito Constitucional");
    Disciplina direitoPrevidenciario = new Disciplina();
    direitoPrevidenciario.setNome("Direito Previdenciario");
    ArrayList<Disciplina> direito = new ArrayList<>();
    Collections.addAll(direito, introDireito, direitoPenal, direitoConstitucional, direitoPrevidenciario);

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


    //endereços
    Endereco endereco1 = new Endereco("Rua das Camélias", "Canoas", "RS", "95280-950", 52);
    Endereco endereco2 = new Endereco("Rua Araçá", "Canoas", "RS", "95560-090", 396);
    Endereco endereco3 = new Endereco("Rua Duque de Caxias", "Porto Alegre", "RS", "93285-365", 590);
    Endereco endereco4 = new Endereco("Rua Demétrio Ribeiro", "Porto Alegre", "RS", "93274-150", 1000);

    //alunos
    Aluno aluno1 = new Aluno("João Torres", "98667412", "joao@torres.com", endereco1, 1000, cienciaDaComputacao);
    Aluno aluno2 = new Aluno("Roberta Vaz", "33459699", "roberta@vaz.com", endereco2, 1000, cienciaDaComputacao);

    //professores
    Colaborador colaborador1 = new Colaborador("Marina Ribeiro", "985923366", "marina@ribeiro.com", endereco3, 9600.00, "Professora");
    Colaborador colaborador2 = new Colaborador("Rodrigo Pereira", "98659916", "rodrigo@pereira.com", endereco4, 8000.00, "Professor");




}