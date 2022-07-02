package service;

import models.Endereco;
import repository.EnderecoRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EnderecoService {
    EnderecoRepository enderecoRepository;

    public EnderecoService() {
        enderecoRepository = new EnderecoRepository();
    }

    public void adicionarEndereco(Endereco endereco) {
        try {
            if (!(this.conferirSeEnderecoExiste(endereco))) {
                enderecoRepository.adicionar(endereco);
            }
        } catch (SQLException e) {
            e.getCause();
        }
    }

    public Boolean conferirSeEnderecoExiste(Endereco endereco) throws SQLException {
        Boolean controle = false;
        int posicao = 0;
        List<Endereco> enderecosDb = enderecoRepository.listar();
        for (Endereco db : enderecosDb) {
            controle = db.getLogradouro().equals(endereco.getLogradouro());
            controle = db.getNumero().equals(endereco.getNumero());
            controle = db.getCidade().equals(endereco.getCidade());
            controle = db.getEstado().equals(endereco.getEstado());
            controle = db.getCep().equals(endereco.getCep());
            if (endereco.getComplemento() != null) {
                controle = db.getComplemento().equals(endereco.getComplemento());
            }
            if (controle) {
                posicao = db.getIdEndereco();
            }
        }
        if (posicao != 0) {
            endereco.setIdEndereco(posicao);
            return true;
        }
        return false;
    }

    public void atualizarEndereco(Endereco endereco) {
        Integer controle = 2;
        try {
            if (enderecoRepository.conferirIdEndereco(endereco.getIdEndereco())) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Atualizar logradouro? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Logradouro:");
                    endereco.setLogradouro(scanner.nextLine());
                } else {
                    endereco.setLogradouro(null);
                }

                System.out.println("Atualizar número? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Número:");
                    endereco.setNumero(Integer.parseInt(scanner.nextLine()));
                }else {
                    endereco.setNumero(null);
                }

                System.out.println("Atualizar complemento? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Complemento:");
                    endereco.setComplemento(scanner.nextLine());
                }else {
                    endereco.setComplemento(null);
                }

                System.out.println("Atualizar cidade? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Cidade:");
                    endereco.setCidade(scanner.nextLine());
                }else {
                    endereco.setCidade(null);
                }

                System.out.println("Atualizar estado? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("Estado:");
                    endereco.setEstado(scanner.nextLine());
                }else {
                    endereco.setEstado(null);
                }

                System.out.println("Atualizar CEP? [1 - Sim / 2 - Não]");
                if (controle == 1) {
                    System.out.println("CEP:");
                    endereco.setCep(scanner.nextLine());
                }else {
                    endereco.setCep(null);
                }

                enderecoRepository.editar(endereco.getIdEndereco(), endereco);
            }
        }catch (SQLException e) {
            e.getCause();
        }
    }
}
