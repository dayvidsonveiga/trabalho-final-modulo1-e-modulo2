package repository;

import models.Colaborador;

import java.sql.*;
import java.util.List;

public class ProfessorRepository implements Repositorio<Integer, Colaborador> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_PROFESSOR.nextval mysequence FROM DUAL";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery((sql));

            if (res.next()) {
                return res.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new SQLException(e.getCause());
        }
    }

    public Integer getProximoRegistroTrabalho(Connection connection) throws SQLException {
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_REGISTRO_TRABALHO.nextval mysequence FROM DUAL";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery((sql));

            if (res.next()) {
                return res.getInt("mysequence");
            }
            return null;
        } catch (SQLException e) {
            throw new SQLException(e.getCause());
        }
    }

    @Override
    public Colaborador adicionar(Colaborador colaborador) throws SQLException {
        Connection con = null;
        int posicao = 0;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoID = this.getProximoId(con);
            Integer proximoRT = this.getProximoRegistroTrabalho(con);
            colaborador.setIdColaborador(proximoID);
            colaborador.setRegistroTrabalho(proximoRT);

            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO PROFESSOR (ID_PROFESSOR, NOME, TELEFONE, EMAIL, REGISTRO_TRABALHO, CARGO, SALÁRIO");
            if (colaborador.getEndereco().getIdEndereco() != null) {
                sql.append(",ID_ENDERECO) \nVALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            } else {
                sql.append(")\nVALUES (?, ?, ?, ?, ?, ?, ?)");
            }

            PreparedStatement statement = con.prepareStatement(sql.toString());

            statement.setInt(1, colaborador.getIdColaborador());
            statement.setString(2, colaborador.getNome());
            statement.setString(3, colaborador.getTelefone());
            statement.setString(4, colaborador.getEmail());
            statement.setInt(5, colaborador.getRegistroTrabalho());
            statement.setString(6, colaborador.getCargo());
            statement.setDouble(7, colaborador.getSalario());
            if (colaborador.getEndereco().getIdEndereco() != null) {
                statement.setInt(8, colaborador.getEndereco().getIdEndereco());
            }

            statement.executeUpdate();
            return colaborador;
        } catch (SQLException e) {
            throw new SQLException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws SQLException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Colaborador endereco) throws SQLException {
        return false;
    }

    @Override
    public List listar() throws SQLException {
        return null;
    }
}
