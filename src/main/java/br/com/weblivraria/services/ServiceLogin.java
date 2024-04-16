package br.com.weblivraria.services;

import java.io.IOException;

import br.com.weblivraria.dao.DAOUsuario;
import br.com.weblivraria.dominio.USER;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceLogin
 */
public class ServiceLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Usuario = request.getParameter("txtUsuario");
		String Senha = request.getParameter("txtSenha");
	
		USER us = new USER();
		us.setNomeuser(Usuario);
		us.setSENHAuser(Senha);
		
		DAOUsuario daous = new DAOUsuario();
		if (daous.login(us)) {
			response.sendRedirect("index.html");
		}else {
			response.sendRedirect("erro.html");
		}
		}
	

}
