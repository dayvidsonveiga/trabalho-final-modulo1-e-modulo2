package service;

import models.Endereco;
import repository.EnderecoRepository;

import java.sql.SQLException;
import java.util.List;

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
}
