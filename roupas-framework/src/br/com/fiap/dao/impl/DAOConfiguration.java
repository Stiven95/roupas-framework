package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.IDAOConfiguration;

public class DAOConfiguration<T> implements IDAOConfiguration<T> {

	private final Class<T> classe;
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public DAOConfiguration(EntityManager em) {
		this.classe = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = em;
	}
	
	@Override
	public void insert(T model) throws Exception {
		em.persist(model);		
	}
	
	public T findById(int id) {
		T model = em.find(classe, id);
		return model;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		return em.createQuery("from "+ classe.getSimpleName() +" c").getResultList();
	}
	
}
