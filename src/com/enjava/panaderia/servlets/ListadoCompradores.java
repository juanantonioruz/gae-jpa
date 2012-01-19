package com.enjava.panaderia.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.enjava.dao.EMFService;
import com.enjava.panaderia.Comprador;

@SuppressWarnings("serial")
public class ListadoCompradores extends HttpServlet {
	private static final Logger log = Logger.getLogger(ListadoCompradores.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		log.info("dejando log!");
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
