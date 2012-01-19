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
import com.enjava.panaderia.Producto;

@SuppressWarnings("serial")
public class AddProducto extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(req.getParameter("nombre")!=null){
			EntityManagerFactory entityManagerFactory = EMFService.get();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Producto c=new Producto();
			c.setNombre(req.getParameter("nombre"));
			entityManager.persist(c);
			writer.print("<h1>Producto incluido correctamente!</h1>");
			
			transaction.commit();
			entityManager.close();
		}else{
		writer.print("<form action='./addProducto' method='GET'>" +
				"<input type='text' name='nombre'>" +
				"<input type='submit'>" +
				"</form>" +
				"");
		}
		
		writer.println("<a href='./listadoProductos'>listadoProductos</a>");
	}
}
