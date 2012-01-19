package com.enjava.panaderia.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.http.*;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import com.enjava.dao.EMFService;
import com.enjava.model.Editorial;
import com.enjava.model.Libro;
import com.enjava.panaderia.Comprador;
import com.enjava.panaderia.PedidoProducto;
import com.enjava.panaderia.Producto;

@SuppressWarnings("serial")
public class ListadoPedidos extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		EntityManagerFactory entityManagerFactory = EMFService.get();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select pedProd from PedidoProducto pedProd";
		List<PedidoProducto> pedidoProductos = entityManager.createQuery(jpql).getResultList();
		writer.print("<h1>Numero de pedidos:"+pedidoProductos.size()+"</h1>");
		writer.print("<ul>");
		for(PedidoProducto c:pedidoProductos){
			writer.print("<li>"+c.getId()+"</li>");
			
		}
		writer.print("</ul>");
		
		
		writer.println("<a href='./addPedido'>addPedido</a>");
	}
}
