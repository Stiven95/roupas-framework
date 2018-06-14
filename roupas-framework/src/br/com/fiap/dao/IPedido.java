package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.model.Pedido;

public interface IPedido extends IDAOConfiguration<Pedido>{
	List<Pedido> listaPedidos();

}
