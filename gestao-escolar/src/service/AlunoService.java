package service;

import models.Aluno;
import models.Colaborador;
import repository.EnderecoRepository;
import repository.AlunoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AlunoService {
    AlunoRepository alunoRepository;

    public AlunoService() {
        alunoRepository = new AlunoRepository();
    }

    public void adicionarAluno(Aluno aluno) {
        try {
            alunoRepository.adicionar(aluno);
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public void removerAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual aluno deseja remover?");
        List<Aluno> alunos = this.listarAlunos();
        int opcao = (Integer.parseInt(scanner.nextLine())) - 1;
        try {
            Integer idEndereco = alunos.get(opcao).getEndereco().getIdEndereco();
            alunoRepository.remover(alunos.get(opcao).getIdAluno());
            EnderecoService enderecoService = new EnderecoService();
            enderecoService.removerEndereco(idEndereco);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarAlunos() {
        try {
            List<Aluno> alunos = alunoRepository.listar();
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println((i + 1) + " - " + alunos.get(i).getNome());
            }
            return alunos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

