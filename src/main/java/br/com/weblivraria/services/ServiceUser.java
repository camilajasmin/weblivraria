package br.com.weblivraria.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.weblivraria.dao.DAOUsuario;
import br.com.weblivraria.dominio.USER;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceUser
 */
public class ServiceUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pagina = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Usuários Cadastrados</title>\r\n"
				+ "    <style>\r\n"
				+ "        h1{\r\n"
				+ "            font-family: arial;\r\n"
				+ "            text-align: center;\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "        h2{\r\n"
				+ "            font-size: 14px;\r\n"
				+ "            margin-right: 20px;\r\n"
				+ "        }\r\n"
				+ "        .dp img{\r\n"
				+ "            width: 16px;\r\n"
				+ "            height: 16px;\r\n"
				+ "            margin: 5px;\r\n"
				+ "        }\r\n"
				+ "        .dp {\r\n"
				+ "            display: flex;\r\n"
				+ "            align-items: center;\r\n"
				+ "            justify-content: space-between;\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "        .dc img{\r\n"
				+ "            height: 15px;\r\n"
				+ "            width: 15px;\r\n"
				+ "            margin: 5px;\r\n"
				+ "        }\r\n"
				+ "        .dc div{\r\n"
				+ "            font-size: 12px;\r\n"
				+ "            font-family: Arial, Helvetica, sans-serif;\r\n"
				+ "            display: flex;\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "       \r\n"
				+ "        .us {\r\n"
				+ "            background-color: lightpink;\r\n"
				+ "            padding: 10px;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            width: 250px;\r\n"
				+ "            transition: ease 0.5s;\r\n"
				+ "            margin:20px;\r\n"
				+ "        }\r\n"
				+ "        .us:hover{\r\n"
				+ "            box-shadow: 0px 0px 5px black;\r\n"
				+ "        }\r\n"
				+ "        #estrutura{\r\n"
				+ "            width: 60%;\r\n"
				+ "            margin-left: auto;\r\n"
				+ "            margin-right: auto;\r\n"
				+"             display:block;\r\n"
				+"             flex-wrap:wrap;\r\n"
				+ "            \r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "        <h1>Usuários Cadastrados</h1>\r\n"
				+ "        <div id=\"estrutura\">\r\n"
				+ "\r\n"
			    ;
		         String conteudo = "";
	
				
		DAOUsuario daous = new DAOUsuario();
		List<USER> list = new ArrayList<USER>();
		list = daous.listar();		
		for(int i = 0; i<list.size(); i++) {
			conteudo +="            <div class=\"us\">\r\n"
					+ "                <div class=\"dp\">\r\n"
					+ "                    <img src=\"userIcon.png\" alt=\"\">\r\n"
					+ "                    <h2>"+list.get(i).getNOMECOMPLETOuser()+"</h2>\r\n"
					+ "                    <a href=\"atualizar.html\">\r\n"
					+ "                        <img src=\"editIcon.png\" alt=\"\">\r\n"
					+ "                    </a>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"dc\">\r\n"
					+ "                    <div><img src=\"phoneIcon.png\" >"+list.get(i).getTELEFONEuser()+"</div>\r\n"
					+ "                    <div><img src=\"mail.png\" >"+list.get(i).getEMAILuser()+"</div>\r\n"
					+ "                </div>\r\n"
					+ "            </div>\r\n"
					+ "            </div>\r\n"
					+ "\r\n"
					;
		}
		
		pagina += conteudo;
		pagina += "\r\n"
				  +"\r\n"
				  + "        </div>\r\n"
				  + "</body>\r\n"
				  + "</html>";
		response.getWriter().write(pagina);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String User = request.getParameter("txtUser");
		String Senha = request.getParameter("txtSenha");
		String Email = request.getParameter("txtEmail");
		String Telefone = request.getParameter("txtTelefone");
		String Nome = request.getParameter("txtNome");
		String CPF = request.getParameter("txtCPF");
		
		// Instância da classe user que está no domínio
		USER us = new USER();
		DAOUsuario ds = new DAOUsuario();
		
		//Passagem dos dados enviados pelo usuário a camada dominio
		
		us.setNomeuser(User);
		us.setSENHAuser(Senha);
		us.setEMAILuser(Email); 
		us.setTELEFONEuser(Telefone); 
		us.setNOMECOMPLETOuser(Nome); 
		us.setCPFuser(CPF); 
		
		//Efetuar o cadastro e exibir a mensagem de retorno
		String msg = ds.cadastrar(us);
		response.getWriter().append(msg);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
