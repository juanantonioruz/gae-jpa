package com.enjava;
import java.io.IOException;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.http.*;

import com.enjava.dao.EMFService;
import com.enjava.model.Editorial;
import com.enjava.model.Libro;

@SuppressWarnings("serial")
public class P1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		Integer contador = (Integer) req.getSession().getAttribute("contador");
		contador++;
		req.getSession().setAttribute("contador", contador);
		EntityManagerFactory entityManagerFactory = EMFService.get();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Editorial editorial=new Editorial();
		Libro l=new Libro();
		l.setNombre("libro_"+contador);
		l.setEditorial(editorial);
		editorial.setNombre(contador+"_editorial");
		entityManager.persist(l);
		
		transaction.commit();
		
		
		resp.getWriter().println("Hello, world"+contador);
	}
}
