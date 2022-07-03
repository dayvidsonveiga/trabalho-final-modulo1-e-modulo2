package repository;

import repository.ConexaoBancoDeDados;
import models.Aluno;
import models.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlunoRepository implements Repositorio<Integer, Aluno>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException{
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_ALUNO.nextval mysequence FROM DUAL";
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

    public Integer getProximoMatricula(Connection connection) throws SQLException {
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_ALUNO_MATRICULA.nextval mysequence FROM DUAL";
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
    public Aluno adicionar(Aluno aluno) throws SQLException {
        Connection con = null;
        int posicao = 0;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoID = this.getProximoId(con);
            Integer proximoMT = this.getProximoMatricula(con);
            aluno.setIdAluno(proximoID);
            aluno.setMatricula(proximoMT);

            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO ALUNO (ID_ALUNO, NOME, TELEFONE, EMAIL, MATRICULA)");
            if (aluno.getCurso().getIdCurso() != null) {
                sql.append(",ID_CURSO) \nVALUES (?, ?, ?, ?, ?, ?)");
            }else if (aluno.getEndereco().getIdEndereco() != null) {
                sql.append(",ID_ENDERECO) \nVALUES (?, ?, ?, ?, ?, ?, ?)");
            } else {
                sql.append(")\nVALUES (?, ?, ?, ?, ?)");
            }

            PreparedStatement statement = con.prepareStatement(sql.toString());

            statement.setInt(1, aluno.getIdAluno());
            statement.setString(2, aluno.getNome());
            statement.setString(3, aluno.getTelefone());
            statement.setString(4, aluno.getEmail());
            statement.setInt(5, aluno.getMatricula());
            if (aluno.getIdCurso() != null) {
                statement.setInt(6, aluno.getCurso().getIdCurso());
            } else if (aluno.getEndereco().getIdEndereco() != null) {
                statement.setInt(7, aluno.getEndereco().getIdEndereco());
            }

            statement.executeUpdate();
            return aluno;
        } catch (SQLException e) {
            e.printStackTrace();
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
    public boolean editar(Integer id, Aluno endereco) throws SQLException {
        return false;
    }

    @Override
    public List<Aluno> listar() throws SQLException {
        return null;
    }

}

