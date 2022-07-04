package repository;

import models.DisciplinaXCurso;
import models.Nota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaRepository {

    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT VEMSER_JEAN.SEQ_NOTAS.nextval mysequence FROM DUAL";
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

    public void adicionerNotasAluno(Nota nota) throws SQLException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoID = this.getProximoId(con);
            nota.setIdNota(proximoID);

            String sql = "INSERT INTO NOTAS (ID_NOTAS, N1, N2, N3, N4, MEDIA, ID_DISCIPLINA, ID_ALUNO)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, nota.getIdNota());
            statement.setDouble(2, nota.getNota1());
            statement.setDouble(3, nota.getNota2());
            statement.setDouble(4, nota.getNota3());
            statement.setDouble(5, nota.getNota4());
            statement.setDouble(6, nota.getMedia());
            statement.setInt(7, nota.getIdDisciplina());
            statement.setInt(8, nota.getIdAluno());

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

    public void removerDisciplinaDoAluno(Integer idAluno, Integer idDisciplina) throws SQLException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM NOTAS WHERE ID_ALUNO = ? AND ID_DISCIPLINA = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idAluno);
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

    public List<Nota> listarPorAluno(Integer idAluno) throws SQLException {
        List<Nota> notas = new ArrayList<>();

        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM NOTAS WHERE ID_ALUNO = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idAluno);

            ResultSet res = statement.executeQuery();
            while (res.next()) {
                notas.add(getFromResultSet(res));
            }

            return notas;
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

    private Nota getFromResultSet(ResultSet res) throws SQLException {
        Nota nota = new Nota();
        nota.setIdNota(res.getInt("ID_NOTAS"));
        nota.setIdAluno(res.getInt("ID_ALUNO"));
        nota.setIdDisciplina(res.getInt("ID_DISCIPLINA"));
        nota.setNota1(res.getDouble("N1"));
        nota.setNota2(res.getDouble("N2"));
        nota.setNota3(res.getDouble("N3"));
        nota.setNota4(res.getDouble("N4"));
        nota.setMedia(res.getDouble("MEDIA"));

        return nota;
    }

    public void removerPorIdDisciplina(Integer idDisciplina) throws SQLException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM NOTAS WHERE ID_DISCIPLINA = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idDisciplina);

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

    public void removerPorIdAluno(Integer idAluno) throws SQLException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM NOTAS WHERE ID_ALUNO = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idAluno);

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
