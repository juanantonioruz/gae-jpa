package com.enjava;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.http.*;

import com.enjava.dao.EMFService;
import com.enjava.model.Editorial;
import com.enjava.model.Libro;

@SuppressWarnings("serial")
public class P2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");

		EntityManagerFactory entityManagerFactory = EMFService.get();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		String jpql = "select editorial from Editorial editorial";
		List<Editorial> editorial = entityManager.createQuery(jpql).getResultList();
		for(Editorial l:editorial)
		resp.getWriter().println("Hello, world"+l.getNombre()+"  - -- "+l.getId()+"\n" );
		
		
		transaction.commit();
		
		
		resp.getWriter().println("Hello, world");
	}
}
