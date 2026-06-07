package br.com.aplcinema.dao;

import br.com.aplcinema.model.Funcionario;
import br.com.aplcinema.utils.SingleConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionariosDAO implements GenericDAO {

    private Connection conexao;
    
    public FuncionariosDAO() throws Exception {
    conexao = SingleConnection.getConnection();
}
    @Override
    public Boolean cadastrar(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        if (funcionario.getId_funcionario()== 0) {
            return this.inserir(funcionario);
        } else {
            return this.alterar(funcionario);
        }
    }

    @Override
    public Boolean inserir(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        String sql = "INSERT INTO FUNCIONARIOS (NOME_FUNCIONARIO, FUNCAO, TELEFONE, EMAIL)"
                   + " VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome_funcionario());
            stmt.setString(2, funcionario.getFuncao());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEmail());
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
        Funcionario funcionario = (Funcionario) objeto;
        String sql = "UPDATE FUNCIONARIOS"
                   + " SET NOME_FUNCIONARIO = ?, FUNCAO = ?, TELEFONE = ?, EMAIL = ?"
                   + " WHERE ID_FUNCIONARIO = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome_funcionario());
            stmt.setString(2, funcionario.getFuncao());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEmail());
            stmt.setInt(5, funcionario.getId_funcionario());
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
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT * FROM FUNCIONARIOS"
                   + " WHERE ID_FUNCIONARIO = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                funcionario.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                funcionario.setNome_funcionario(rs.getString("NOME_FUNCIONARIO"));
                funcionario.setFuncao(rs.getString("FUNCAO"));
                funcionario.setTelefone(rs.getString("TELEFONE"));
                funcionario.setEmail(rs.getString("EMAIL"));
            }
        } catch (Exception ex) {
            
                System.out.println("Problemas ao carregar! Erro: " + ex.getMessage());
                ex.printStackTrace();
        }
    return funcionario;
    }

    @Override
    public Boolean excluir(int id) {
        Funcionario funcionario = new Funcionario();
        String sql = "DELETE FROM FUNCIONARIOS"
                   + " WHERE ID_FUNCIONARIO = ?";
        
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
        String sql = "SELECT * FROM FUNCIONARIOS"
                   + " ORDER BY ID_FUNCIONARIO";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                funcionario.setNome_funcionario(rs.getString("NOME_FUNCIONARIO"));
                funcionario.setFuncao(rs.getString("FUNCAO"));
                funcionario.setTelefone(rs.getString("TELEFONE"));
                funcionario.setEmail(rs.getString("EMAIL"));

                resultado.add(funcionario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }
}