package br.com.fiap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCliente;
	
	private String nome;
	
	private String cpfCnpj;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long idCliente, String nome, String cpfCnpj) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long id) {
		this.idCliente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	
}
