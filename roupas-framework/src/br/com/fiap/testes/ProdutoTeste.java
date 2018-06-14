package br.com.fiap.testes;

import java.util.Random;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.ProdutoDAO;
import br.com.fiap.model.Produto;
import br.com.fiap.util.JPAUtil;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		EntityManager em;
		em = JPAUtil.getEntityManager();

		String[] roupas = { "Camiseta", "Meia", "Cueca", "Calcinha", "Calça", "Moleton", "Boné", "Meia Calça", "Sutien", "Vestido", "Camisa Social" };
		String[] tamanho = { "P", "M", "G", "GG", "XG", "XXG" };
		String[] caract = { "Verde", "Florida", "Listrada", "Lisa", "Amarela", "Branca", "Verde", "Preta", "Vermelha", "Rosa" };

		int roupasLen = roupas.length-1;
		int tamanhoLen = tamanho.length-1;
		int caractLen = caract.length-1;

		ProdutoDAO dao = new ProdutoDAO(em);

		try {
			em.getTransaction().begin();

			for (int i = 0; i < 1000; i++) {

				Produto produto = new Produto();
				produto.setDescricao(
						roupas[ran(roupasLen)] + " " + caract[ran(caractLen)] + " " + tamanho[ran(tamanhoLen)]);
				produto.setPreco(preco());

				dao.insert(produto);

			}
				em.getTransaction().commit();
				em.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int ran(int limit) {
		Random rand = new Random();
		int value = rand.nextInt(limit);
		return value;
	}

	private static double preco() {
		Random rand = new Random();
		int value = rand.nextInt(200) + 1;
		return value;
	}

}
