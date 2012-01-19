package com.enjava.panaderia.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.http.*;

import com.enjava.dao.EMFService;
import com.enjava.model.Editorial;
import com.enjava.model.Libro;
import com.enjava.panaderia.Comprador;
import com.enjava.panaderia.PedidoProducto;
import com.enjava.panaderia.Producto;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class AddPedido extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		EntityManagerFactory entityManagerFactory = EMFService.get();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		if(req.getParameter("producto")!=null){
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			PedidoProducto c=new PedidoProducto();
			c.setComprador(KeyFactory.createKey("Comprador", req.getParameter("comprador")));
			c.setProducto(KeyFactory.createKey("Producto", req.getParameter("producto")));
			entityManager.persist(c);
			writer.print("<h1>Pedido incluido correctamente!</h1>");
			
			transaction.commit();
		}else{
			writer.print(req.getParameter("producto_id"));
		Comprador find = entityManager.find(Comprador.class, KeyFactory.createKey("Comprador", 276));
		String jpql = "select comprador from Comprador comprador";
		List<Comprador> compradores=entityManager.createQuery(jpql).getResultList();
		writer.print("<form action='./addPedido' method='GET'>" +
				"<input type='text' name='producto' value='"+req.getParameter("producto_id")+"'>" +
				"<select name='comprador'>");
		for(Comprador c:compradores){
				writer.print("<option value='"+c.getId().getId()+"'>"+c.getNombre()+"</option>");
		}
		
				writer.print("</select>"+
				
				"<input type='submit'>" +
				"</form>" +
				"");
		}
		
		writer.println("<a href='./listadoPedidos'>listadoPedidos</a>");
		entityManager.close();
	}
}
