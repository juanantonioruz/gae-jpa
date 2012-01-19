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
import com.enjava.panaderia.Producto;

@SuppressWarnings("serial")
public class ListadoProductos extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		EntityManagerFactory entityManagerFactory = EMFService.get();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select producto from Producto producto";
		List<Producto> productos = entityManager.createQuery(jpql).getResultList();
		writer.print("<h1>Numero de productos:"+productos.size()+"</h1>");
		writer.print("<ul>");
		for(Producto c:productos){
			writer.print("<li>"+c.getNombre()+"<a href='./addPedido?producto_id="+c.getId().getId()+"'>add Pedido</a></li>");
			
		}
		writer.print("</ul>");
		
		
		writer.println("<a href='./addProducto'>add Producto</a>");
	}
}
