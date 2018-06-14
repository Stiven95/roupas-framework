package br.com.fiap.dao;

public interface IDAOConfiguration<T> {
	void insert(T model) throws Exception;
}
