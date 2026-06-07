package br.com.aplcinema.dao;

import br.com.aplcinema.model.Filme;
import br.com.aplcinema.utils.SingleConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FilmesDAO implements GenericDAO {

    private Connection conexao;
    
    public FilmesDAO() throws Exception {
    conexao = SingleConnection.getConnection();
}
    @Override
    public Boolean cadastrar(Object objeto) {
        Filme filme = (Filme) objeto;
        if (filme.getId_filme() == 0) {
            return this.inserir(filme);
        } else {
            return this.alterar(filme);
        }
    }

    @Override
    public Boolean inserir(Object objeto) {
        Filme filme = (Filme) objeto;
        String sql = "INSERT INTO FILMES (NOME_FILME, DATA_LANCAMENTO, DURACAO_MINUTOS)"
                   + " VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome_filme());
            stmt.setDate(2, (Date) filme.getData_lancamento());
            stmt.setInt(3, filme.getDuracao_minutos());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao inserir! Erro: " + ex.getMessage());
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
        Filme filme = (Filme) objeto;
        String sql = "UPDATE FILMES"
                   + " SET NOME_FILME = ?, DATA_LANCAMENTO = ?, DURACAO_MINUTOS = ?"
                   + " WHERE ID_FILME = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome_filme());
            stmt.setDate(2, (Date) filme.getData_lancamento());
            stmt.setInt(3, filme.getDuracao_minutos());
            stmt.setInt(4, filme.getId_filme());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar! Erro: " + ex.getMessage());
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
    public Object carregar(int id) {
        Filme filme = new Filme();
        String sql = "SELECT * FROM FILMES"
                   + " WHERE ID_FILME = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                filme.setId_filme(rs.getInt("ID_FILME"));
                filme.setNome_filme(rs.getString("NOME_FILME"));
                filme.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
                filme.setDuracao_minutos(rs.getInt("DURACAO_MINUTOS"));
            }
        } catch (Exception ex) {
            
                System.out.println("Problemas ao carregar! Erro: " + ex.getMessage());
                ex.printStackTrace();
        }
    return filme;
    }

    @Override
    public Boolean excluir(int id) {
        Filme filme = new Filme();
        String sql = "DELETE FROM FILMES"
                   + " WHERE ID_FILME = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao excluir! Erro: " + ex.getMessage());
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
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        String sql = "SELECT * FROM FILMES"
                   + " ORDER BY ID_FILME";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId_filme(rs.getInt("ID_FILME"));
                filme.setNome_filme(rs.getString("NOME_FILME"));
                filme.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
                filme.setDuracao_minutos(rs.getInt("DURACAO_MINUTOS"));

                resultado.add(filme);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }
}