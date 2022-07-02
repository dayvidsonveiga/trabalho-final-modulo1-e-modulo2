package repository;

import models.Colaborador;
import models.Disciplina;

import java.sql.*;
import java.util.List;

public class DisciplinaRepository implements Repositorio<Integer, Disciplina> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_DISCIPLINA.nextval mysequence FROM DUAL";
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
    public Disciplina adicionar(Disciplina disciplina) throws SQLException {
        Connection con = null;
        int posicao = 0;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoID = this.getProximoId(con);
            disciplina.setIdDisciplina(proximoID);

            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO VEMSER_JEAN.DISCIPLINA (ID_DISCIPLINA, NOME");
            if (disciplina.getProfessor().getIdColaborador() != null) {
                sql.append(",ID_PROFESSOR \n VALUES (?, ?, ?)");
            } else {
                sql.append(")\nVALUES (?, ?)");
            }

            PreparedStatement statement = con.prepareStatement(sql.toString());

            statement.setInt(1, disciplina.getIdDisciplina());
            statement.setString(2, disciplina.getNome());
            if (disciplina.getProfessor().getIdColaborador() != null) {
                statement.setInt(3, disciplina.getProfessor().getIdColaborador());
            }

            statement.executeUpdate();
            return disciplina;
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
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM DISCIPLINA WHERE ID_DISCIPLINA = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);

            return statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.getCause();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Disciplina disciplina) throws SQLException {

    }

    @Override
    public List<Disciplina> listar() throws SQLException {
        return null;
    }


}