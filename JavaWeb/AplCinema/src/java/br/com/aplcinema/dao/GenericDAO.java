package br.com.aplcinema.dao;

import java.util.List;

public abstract interface GenericDAO {
    
    public Boolean cadastrar(Object objeto);
    public Boolean inserir(Object objeto);
    public Boolean alterar(Object objeto);
    public Object carregar(int id);
    public Boolean excluir(int id);
    public List<Object> listar();
}
