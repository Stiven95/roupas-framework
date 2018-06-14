package br.com.fiap.testes;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.PedidoDAO;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Pedido;
import br.com.fiap.util.JPAUtil;

public class PedidoTeste {

	public static void main(String[] args) {
		EntityManager em;
		em = JPAUtil.getEntityManager();

		PedidoDAO dao = new PedidoDAO(em);

		try {

			em.getTransaction().begin();

			for (int i = 0; i < 1000; i++) {
				Pedido pedido = new Pedido();
				Cliente cli = new Cliente();
				cli.setIdCliente(ran(1000));
				pedido.setCliente(cli);
				pedido.setData(diadacompra());
				dao.insert(pedido);
			}

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
		}

	}

	private static int ran(int limit) {
		Random rand = new Random();
		int value = rand.nextInt(limit) + 1;
		return value;
	}

	private static LocalDate diadacompra() {
		long minDay = LocalDate.of(2018, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(2018, 6, 12).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}
}
