package br.com.aplcurso.dao;

import br.com.aplcurso.model.Estado;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements GenericDAO {

    private Connection conexao;

    public EstadoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        if (oEstado.getId() == 0) {
            return this.inserir(oEstado);
        } else {
            return this.alterar(oEstado);
        }
    }

    @Override
    public Boolean inserir(Object objeto) {
        Estado oEstado = (Estado) objeto;
        String sql = "INSERT INTO estado (nomeestado, siglaestado) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, oEstado.getNomeEstado());
            stmt.setString(2, oEstado.getSiglaEstado());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao inserir o Estado! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        String sql = "UPDATE estado SET nomeestado = ?, siglaestado = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, oEstado.getNomeEstado());
            stmt.setString(2, oEstado.getSiglaEstado());
            stmt.setInt(3, oEstado.getId());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Estado! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        String sql = "DELETE FROM estado WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao excluir o Estado! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        String sql = "SELECT * FROM estado WHERE id = ?";
        Estado oEstado = null;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                oEstado = new Estado();
                oEstado.setId(rs.getInt("id"));
                oEstado.setNomeEstado(rs.getString("nomeestado"));
                oEstado.setSiglaEstado(rs.getString("siglaestado"));
            }
            return oEstado;
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar estado: " + ex.getMessage());
            ex.printStackTrace();
        }
        return oEstado;
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        String sql = "SELECT * FROM estado ORDER BY nomeestado";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estado oEstado = new Estado();
                oEstado.setId(rs.getInt("id"));
                oEstado.setNomeEstado(rs.getString("nomeestado"));
                oEstado.setSiglaEstado(rs.getString("siglaestado"));
                resultado.add(oEstado);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar estados: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean siglaExiste(String sigla, int id) {
        String sql = "SELECT COUNT(*) AS quantidade FROM estado WHERE siglaestado = ? AND id <> ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, sigla.toUpperCase());
            stmt.setInt(2, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("quantidade") > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}