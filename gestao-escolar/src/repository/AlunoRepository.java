package repository;

import models.Colaborador;
import models.Disciplina;
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
        Integer index = 1;
        int posicao = 0;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoID = this.getProximoId(con);
            Integer proximoMT = this.getProximoMatricula(con);
            aluno.setIdAluno(proximoID);
            aluno.setMatricula(proximoMT);

            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO ALUNO (ID_ALUNO, NOME, TELEFONE, EMAIL, MATRICULA");
            if (aluno.getEndereco().getIdEndereco() == null && aluno.getCurso() == null) {
                sql.append(" ) VALUES (?, ?, ?, ?, ?)" );
            }
            if (aluno.getIdCurso() != null && aluno.getEndereco().getIdEndereco() == null) {
                sql.append(",ID_CURSO) VALUES (?, ?, ?, ?, ?, ?)");
            }
            if (aluno.getEndereco().getIdEndereco() != null && aluno.getIdCurso() == null) {
                sql.append(",ID_ENDERECO) VALUES (?, ?, ?, ?, ?, ?)");
            }
            if (aluno.getIdCurso() != null && aluno.getEndereco().getIdEndereco() != null) {
                sql.append(" ) VALUES (?, ?, ?, ?, ?, ?, ?)");
            }

            PreparedStatement statement = con.prepareStatement(sql.toString());

            statement.setInt(index++, aluno.getIdAluno());
            statement.setString(index++, aluno.getNome());
            statement.setString(index++, aluno.getTelefone());
            statement.setString(index++, aluno.getEmail());
            statement.setInt(index++, aluno.getMatricula());
            if (aluno.getIdCurso() != null) {
                statement.setInt(index++, aluno.getIdCurso());
            } else if (aluno.getEndereco().getIdEndereco() != null) {
                statement.setInt(index++, aluno.getEndereco().getIdEndereco());
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
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM ALUNO WHERE ID_ALUNO = ?";

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
    public boolean editar(Integer id, Aluno endereco) throws SQLException {
    return false;
    }

    @Override
    public List<Aluno> listar() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();

        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM ALUNO";

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                alunos.add(getAlunoFromResultSet(res));
            }
            return alunos;
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

    private Aluno getAlunoFromResultSet(ResultSet res) throws SQLException {
        Aluno aluno = new Aluno(res.getString("NOME"));
        aluno.setIdAluno(res.getInt("ID_ALUNO"));
        aluno.setTelefone(res.getString("TELEFONE"));
        aluno.setEmail(res.getString("EMAIL"));
        aluno.setMatricula(res.getInt("MATRICULA"));
        return aluno;
    }

    public List<Aluno> conferirAlunosComIdEndereco(Integer id) throws SQLException{
        List<Aluno> quantidadeAlunos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT *" +
                    "FROM PROFESSOR \n" +
                    "WHERE PROFESSOR.ID_ENDERECO = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                quantidadeAlunos.add(getAlunoFromResultSet(res));
            }
            System.out.println(quantidadeAlunos.size());
            return quantidadeAlunos;
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
}

