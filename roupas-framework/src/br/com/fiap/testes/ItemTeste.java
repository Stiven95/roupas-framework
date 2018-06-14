package br.com.fiap.testes;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.ItemDAO;
import br.com.fiap.dao.impl.PedidoDAO;
import br.com.fiap.dao.impl.ProdutoDAO;
import br.com.fiap.model.Item;
import br.com.fiap.model.Pedido;
import br.com.fiap.model.Produto;
import br.com.fiap.util.JPAUtil;

public class ItemTeste {

	public static void main(String[] args) {
		EntityManager em;
		em = JPAUtil.getEntityManager();

		ProdutoDAO pDao = new ProdutoDAO(em);
		PedidoDAO pedDAO = new PedidoDAO(em);
		ItemDAO dao = new ItemDAO(em);

		try {

			em.getTransaction().begin();

			List<Pedido> pedidos = pedDAO.listAll();

			for (Pedido pedido : pedidos) {

				for (int i = 0; i < ran(3); i++) {
					
					Item item = new Item();
					item.setQtd(ran(4));

					Produto p = new Produto();
					int id = ran(1000);
					p.setIdProduto(id);
					item.setPreco(pDao.findById(id).getPreco());
					item.setProduto(p);

					Pedido pe = new Pedido();
					pe.setIdPedido((pedido.getIdPedido()));
					item.setPedido(pe);

					dao.insert(item);
				}
			}

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int ran(int limit) {
		Random rand = new Random();
		int value = rand.nextInt(limit) + 1;
		return value;
	}
}
