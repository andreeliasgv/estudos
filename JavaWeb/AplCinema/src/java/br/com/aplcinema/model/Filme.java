package br.com.aplcinema.model;

import java.util.Date;
import java.util.Objects;

public class Filme {
    
    private Integer id_filme;
    private String nome_filme;
    private Date data_lancamento;
    private Integer duracao_minutos;

    public Filme() {
        this.id_filme = 0;
        this.nome_filme = "";
        this.data_lancamento = null;
        this.duracao_minutos = 0;
    }

    public Filme(Integer id_filme, String nome_filme, Date data_lancamento, Integer duracao_minutos) {
        this.id_filme = id_filme;
        this.nome_filme = nome_filme;
        this.data_lancamento = data_lancamento;
        this.duracao_minutos = duracao_minutos;
    }

    public Integer getId_filme() {
        return id_filme;
    }

    public void setId_filme(Integer id_filme) {
        this.id_filme = id_filme;
    }

    public String getNome_filme() {
        return nome_filme;
    }

    public void setNome_filme(String nome_filme) {
        this.nome_filme = nome_filme;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Integer getDuracao_minutos() {
        return duracao_minutos;
    }

    public void setDuracao_minutos(Integer duracao_minutos) {
        this.duracao_minutos = duracao_minutos;
    }
    
    
}
