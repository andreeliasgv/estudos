package br.com.aplcinema.model;

import java.util.Objects;
public class Funcionario {
    
    private Integer id_funcionario;
    private String nome_funcionario;
    private String funcao;
    private String telefone;
    private String email;

    public Funcionario() {
        this.id_funcionario = 0;
        this.nome_funcionario = "";
        this.funcao = "";
        this.telefone = "";
        this.email = "";
    }

    public Funcionario(Integer id_funcionario, String nome_funcionario, String funcao, String telefone, String email) {
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.funcao = funcao;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
