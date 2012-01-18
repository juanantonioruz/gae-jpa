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
public class DisconectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/HTML");
		req.getSession().invalidate();


		
		
		
		resp.getWriter().println("Desconectado<a href='index.html>index</a>'");
	}
}
