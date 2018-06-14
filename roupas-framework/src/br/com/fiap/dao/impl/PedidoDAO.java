package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.IPedido;
import br.com.fiap.model.Pedido;

public class PedidoDAO extends DAOConfiguration<Pedido> implements IPedido{

	protected EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		super(em);
		this.em = em;
	}
	
	@Override
	public List<Pedido> listaPedidos() {
		return null;
	}

}
