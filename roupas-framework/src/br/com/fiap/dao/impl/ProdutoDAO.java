package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.IProduto;
import br.com.fiap.model.Produto;

public class ProdutoDAO extends DAOConfiguration<Produto> implements IProduto{

	protected EntityManager em;
	
	public ProdutoDAO(EntityManager em) {
		super(em);
		this.em = em;
	}
}
