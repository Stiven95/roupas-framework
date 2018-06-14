package br.com.fiap.testes;

import java.util.Random;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.ClienteDAO;
import br.com.fiap.model.Cliente;
import br.com.fiap.util.JPAUtil;

public class ClienteTeste {

	static String[] nomes = {"Stiven","Evair","Lucas","Amanda","Luzia","Raquel","Raphael","Adriano","Renata","Julio"};
	static String[] meionomes = {"Oliveira","Sousa","Prado","Santos","Jardim","Vanini","Campos","Sales","Kremmer","Hubrecht"};
	static String[] sobrenomes = {"Bezerra","Costa","Pereira","Rodrigues","Finn","Martin","Henckes","Cristensen","Rebel","Rabelo"};
	
	public static void main(String[] args) {
		EntityManager em;
		em = JPAUtil.getEntityManager();
		
		ClienteDAO dao = new ClienteDAO(em);		
		
		try {
			em.getTransaction().begin();
			int cpf = 1;
			for (int i = 0; i < 1000; i++){
				String fn = "";
			Cliente cliente = new Cliente();
			cliente.setNome(nomes[ran()] + " " + meionomes[ran()] + " " + sobrenomes[ran()]);
			if (cpf < 10){
				fn = "000" + cpf;
			} else if (cpf >=10 && cpf < 100){
				fn = "00" + cpf;
			} else if (cpf >= 100 && cpf < 1000){
				fn = "0" + cpf;
			} else {
				fn = cpf + "";
			}
			cpf++;
			cliente.setCpfCnpj("1568385" + fn);
			dao.insert(cliente);
			}
			em.getTransaction().commit();
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static int ran(){
		Random rand = new Random(); 
		int value = rand.nextInt(9);
		return value;
	}
}
