package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ICliente;
import br.com.fiap.model.Cliente;

public class ClienteDAO extends DAOConfiguration<Cliente> implements ICliente{

	protected EntityManager em;
	public ClienteDAO(EntityManager em) {
		super(em);
		this.em = em;
	}
}
