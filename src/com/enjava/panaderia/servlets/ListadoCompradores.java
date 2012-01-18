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

@SuppressWarnings("serial")
public class ListadoCompradores extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		EntityManagerFactory entityManagerFactory = EMFService.get();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "select comprador from Comprador comprador";
		List<Comprador> compradores = entityManager.createQuery(jpql).getResultList();
		writer.print("<h1>Numero de compradores:"+compradores.size()+"</h1>");
		writer.print("<ul>");
		for(Comprador c:compradores){
			writer.print("<li>"+c.getNombre()+"</li>");
			
		}
		writer.print("</ul>");
		
		
		writer.println("<a href='./addComprador'>add comprador</a>");
	}
}
