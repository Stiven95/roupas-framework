package br.com.fiap.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.PedidoDAO;
import br.com.fiap.model.Pedido;
import br.com.fiap.util.PDF;
import br.com.fiap.util.JPAUtil;

public class TestaListaNotas {
	
	public static void main(String[] args) {
			
			EntityManager em;
			em = JPAUtil.getEntityManager();
			
			PedidoDAO dao = new PedidoDAO(em);
			
			try {
				PDF invoice = new PDF();
				List<Pedido> pedidos = dao.listAll();
				
				for (Pedido pedido : pedidos) {
					//System.out.println(pedido.getItems().get(0).getPreco());
					invoice.generate(pedido);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("------- WORK FINISHED -------");
			}
	
		}
}
