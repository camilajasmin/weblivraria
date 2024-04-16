package br.com.weblivraria.services;

import java.io.IOException;

import br.com.weblivraria.dao.DAOlivro;
import br.com.weblivraria.dominio.LIVRO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceLivro
 */
public class ServiceLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceLivro() {
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
		String titulo = request.getParameter("txtTituloLivro");
		String genero = request.getParameter("cbogenero");
		String sinopse = request.getParameter("textareaSinopse");
		String autor = request.getParameter("Autor");
	    String preco = request.getParameter("txtPreco");
		String capa = request.getParameter("Capa");
		
		LIVRO lv = new LIVRO();
		lv.setTITULOlivro(titulo);
		lv.setGENEROlivro(genero);
		lv.setSINOPSElivro(sinopse);
		lv.setAUTORlivro(autor);
		lv.setPRECOlivro(Double.parseDouble(preco));
		lv.setCAPAlivro(capa);
		
		DAOlivro dv = new DAOlivro();
		String msg = dv.cadastrar(lv);
		if(msg.equals("Cadastro realizado")){
			response.sendRedirect("confirmacao.html");
			}
		else {
			response.getWriter().append(msg);
		}
		}

}
