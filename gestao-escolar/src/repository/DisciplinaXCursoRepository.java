package repository;

import models.DisciplinaXCurso;

import java.sql.*;

public class DisciplinaXCursoRepository {

    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_DISCIPLINA_X_CURSO.nextval mysequence FROM DUAL";
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
    public void adicionarDisciplinaNoCurso(DisciplinaXCurso disciplinaXCurso) throws SQLException{
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoID = this.getProximoId(con);
            disciplinaXCurso.setId(proximoID);

            String sql = "INSERT INTO DISCIPLINA_X_CURSO (ID_DISCIPLINA_X_CURSO, ID_DISCIPLINA, ID_CURSO)" +
                    " VALUES (?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, disciplinaXCurso.getId());
            statement.setInt(2, disciplinaXCurso.getIdDisciplina());
            statement.setInt(3, disciplinaXCurso.getIdCurso());

            statement.executeUpdate();
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

    public void removerDisciplinaDoCurso(Integer idDisciplina, Integer idCurso) throws SQLException{
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM DISCIPLINA_X_CURSO WHERE ID_CURSO = ? AND ID_DISCIPLINA = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idCurso);
            statement.setInt(2, idDisciplina);

            statement.execute();
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

}
