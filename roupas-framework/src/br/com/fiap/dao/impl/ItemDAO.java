package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.IItem;
import br.com.fiap.model.Item;

public class ItemDAO extends DAOConfiguration<Item> implements IItem{

	protected EntityManager em;
	
	public ItemDAO(EntityManager em) {
		super(em);
		this.em = em;
	}
}
