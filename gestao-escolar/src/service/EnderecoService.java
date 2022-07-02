package service;

import models.Endereco;
import repository.EnderecoRepository;

import java.sql.SQLException;

public class EnderecoService {
    EnderecoRepository enderecoRepository;

    public EnderecoService(){enderecoRepository = new EnderecoRepository();}

    public void adicionarEndereco(Endereco endereco) {
        try {
            enderecoRepository.adicionar(endereco);
        }catch (SQLException e) {
            e.getCause();
        }
    }
}
