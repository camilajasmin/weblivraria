package br.com.weblivraria.services;

import java.io.IOException;

import br.com.weblivraria.dao.DAOpedido;
import br.com.weblivraria.dominio.PEDIDO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServicePagamento
 */
public class ServiceFinalizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceFinalizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina ="<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				
				+ "<style>\r\n"
				+ "    body{\r\n"
				+ "        margin: 0px;\r\n"
				+ "        padding: 0px;\r\n"
				+ "    }\r\n"
				+ "    header{\r\n"
				+ "        background-color: #cdc2b7  ;\r\n"
				+ "        color: white;\r\n"
				+ "        font-family: verdana;\r\n"
				+ "    }\r\n"
				+ "    #areaUsuario{\r\n"
				+ "        padding: 10px;\r\n"
				+ "        border-bottom: 1px solid white ;\r\n"
				+ "        display: flex;\r\n"
				+ "        justify-content: space-between;\r\n"
				+ "        color: #3d545b ;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #areaPesquisa{\r\n"
				+ "        display: flex;\r\n"
				+ "        justify-content: center;\r\n"
				+ "        align-items: center;\r\n"
				+ "        height: 100px;\r\n"
				+ "        border-bottom: 1px solid white ;\r\n"
				+ "    }\r\n"
				+ "    form{\r\n"
				+ "        background-color: white;\r\n"
				+ "        padding: 10px;\r\n"
				+ "        margin-left: 50px;\r\n"
				+ "        margin-right:50px ;\r\n"
				+ "    }\r\n"
				+ "    input[type=text]{\r\n"
				+ "        width: 500px;\r\n"
				+ "        padding: 5px;\r\n"
				+ "        border: 0px;\r\n"
				+ "        outline: none;\r\n"
				+ "    }\r\n"
				+ "    input[type=submit]{\r\n"
				+ "        background-color: cornflowerblue;\r\n"
				+ "        color: white;\r\n"
				+ "        border: none;\r\n"
				+ "        font-size: 10px;\r\n"
				+ "        padding: 5px;\r\n"
				+ "    }\r\n"
				+ "    #carrinho {\r\n"
				+ "        background-color: white;\r\n"
				+ "        padding: 10px;\r\n"
				+ "        color: black !important;\r\n"
				+ "    }\r\n"
				+ "    #carrinho img{\r\n"
				+ "        width: 20px;\r\n"
				+ "        height: 20px;\r\n"
				+ "        margin-right: 10px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    #areaMenu{\r\n"
				+ "        text-align: center;\r\n"
				+ "        align-items: center;\r\n"
				+ "    }\r\n"
				+ "    #areaMenu a{\r\n"
				+ "        text-decoration: none;\r\n"
				+ "        margin-left: 10px;\r\n"
				+ "        margin-right: 10px;\r\n"
				+ "        color: #3d545b;\r\n"
				+ "        font-size: 15px;\r\n"
				+ "    }\r\n"
				+ "    #areaMenu a:hover{\r\n"
				+ "        color: white;\r\n"
				+ "    }\r\n"
				+ "    #copy{\r\n"
				+ "        text-align: center;\r\n"
				+ "        padding: 20px;\r\n"
				+ "        border-top: 1px solid silver;\r\n"
				+ "        \r\n"
				+ "    }\r\n"
				+ "    footer{\r\n"
				+ "        background-color: #cdc2b7;\r\n"
				+ "        font-family: Verdana;\r\n"
				+ "        justify-content: space-between;\r\n"
				+ "    }\r\n"
				+ "    #footer{\r\n"
				+ "        font-size: 12px;\r\n"
				+ "        \r\n"
				+ "        \r\n"
				+ "    }\r\n"
				+ "    h2{\r\n"
				+ "        font-family: verdana;\r\n"
				+ "        font-size: 12px;\r\n"
				+ "    }\r\n"
				+ "    #footer img{\r\n"
				+ "        width: 18px;\r\n"
				+ "        height: 18px;\r\n"
				+ "    }\r\n"
				+ "    #genero a{\r\n"
				+ "        font-family: verdana;\r\n"
				+ "        font-size: 12px;\r\n"
				+ "        text-decoration: none;\r\n"
				+ "        display: block;\r\n"
				+ "    }\r\n"
				+ "    .pagamento{"
				+ "        display:flex !important;"
				+ "        margin:30px;"
				+ "        padding: 20px;"
				+ "		   border: 1px solid #ddd;"
				+ "        justify-content: space-between;"
				+ "        align-items: center;}"
				
				+ "    .pagamento img{"
				+ "     width:80px;"
				+ "		height:110px;"
				+ "     margin:10px;"
				+ "}"
				+ "		.pagamento label{"
				+ "     margin-right:20px;"
				+ "     font-weight:bold;}"
				+ ""
				+ "     .pagamento input[type=number]{"
				+ "     margin-right:30px;"
				+ "}"
				+ "     .pagamento button{"
				+ "     padding:10px;"
				+ "     background-color:red;"
				+ "     color:white;"
				+ "     shadow: 1px black"
				+ "     border:1px"
				+ "     "
				+ "}"
				+ ".pagamento .pag{"
				+ "text-decoration:none;"
				+ "background-color:brown;"
				+ "color:white;"
				+ "padding:10px;"
				+ "}"
				+ "</style>\r\n"
				+ "<script>\r\n"
				+ "        function Subtotal(){\r\n"
				+ "            var Preco = document.getElementById(\"preco\").innerText;\r\n"
				+ "            var Qtd = document.getElementById(\"qtd\").value;\r\n"
				+ "            document.getElementById(\"resultado\").innerText=Preco*Qtd;\r\n"
				+ "        }\r\n"
				+ "    </script>"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <header>\r\n"
				+ "        <div id=\"areaUsuario\">\r\n"
				+ "            <div id=\"localizacao\">\r\n"
				+ "                <img src=\"pinLocation.png\" width=\"25px\" height=\"26px\">\r\n"
				+ "                Localização da Loja\r\n"
				+ "            </div>\r\n"
				+ "            <div id=\"usuario\">\r\n"
				+ "                <img src=\"loginIcon.png\" width=\"20px\" height=\"20px\">\r\n"
				+ "                Logar/Cadastrar\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div id=\"areaPesquisa\">\r\n"
				+ "            <img src=\"logoicon.png\" width=\"150px\" height=\"90px\">\r\n"
				+ "\r\n"
				+ "            <form action=\"ServiceSearch\" method=\"get\">\r\n"
				+ "                <img src=\"lupaIcon.png\" width=\"16px\" height=\"16px\">\r\n"
				+ "                <input type=\"text\" placeholder=\"Pesquise seu livro aqui!\">\r\n"
				+ "                <input type=\"submit\" value=\"BUSCAR\">\r\n"
				+ "            </form>\r\n"
				+ "            <div id=\"carrinho\" class=\"carrinho\"><img src=\"carrinho.png\">R$ 0,00</div>\r\n"
				+ "            \r\n"
				+ "        </div>\r\n"
				+ "        <div id=\"areaMenu\">\r\n"
				+ "            <nav>\r\n"
				+ "                <a href=\"HOME\">\r\n"
				+ "                    HOME\r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    AVENTURA\r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    TERROR\r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    FANTASIA\r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    ROMANCE\r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    SUSPENSE\r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    DRAMA   \r\n"
				+ "                </a>\r\n"
				+ "                <a href=\"#\">\r\n"
				+ "                    AÇÃO\r\n"
				+ "                </a>\r\n"
				+ "            </nav>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    </header>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <content>\r\n"
				+ "        <div id=\"painel\"><img src=\"painel.png\" width=\"100%\"></div>\r\n"
				+ "        \r\n"
				+ "            <h3>Nossos Produtos</h3>\r\n"
				+ "            <div id=\"listalivros\">\r\n"
				;
				String livroId = request.getParameter("IDlivro");
				String qtd = request.getParameter("qtd");
				String subtotal = request.getParameter("subtotal");
				
				String conteudo = "";
				PEDIDO pdd = new PEDIDO();
				DAOpedido daop = new DAOpedido();
				
				pdd.setIDUser(1);
				pdd.setTOTALpedido(Double.parseDouble(subtotal));
				
				if(daop.cadastrar(pdd).equals("Pedido Efetuado")) {
					conteudo += "<h2>Pedido efetuado com sucesso</h2>";
					
				}else {
					conteudo += "<h2>Erro ao fazer o pedido</h2>";
				}
				
				
					
					pagina+=conteudo;
				
				
				pagina+="            </div>\r\n"
				+ "    </content>\r\n"
				+ "\r\n"
				+ "    <footer>\r\n"
				+ "        <div id=\"footer\">\r\n"
				+ "            <div id=\"contato\">\r\n"
				+ "                <h2>Entre em contato conosco</h2>\r\n"
				+ "                <a href=\"https://wa.me/5511982108134\"><img src=\"logowpp.png\" alt=\"(11) 982108134\"><br>\r\n"
				+ "                </a> (11) 94040-0492 | 93445-3223 <br>\r\n"
				+ "                Av. Paulo Rodrigues, 233 - Jardim Label - São Paulo - SP <br>\r\n"
				+ "                \r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "            <div id=\"genero\">\r\n"
				+ "                <h2>Generos</h2>\r\n"
				+ "                <nav>\r\n"
				+ "                    <a href=\"#\">HOME</a>\r\n"
				+ "                    <a href=\"#\">Romance</a>\r\n"
				+ "                    <a href=\"#\">Aventura</a>\r\n"
				+ "                    <a href=\"#\">Terror</a>\r\n"
				+ "                    <a href=\"#\">Fantasia</a>\r\n"
				+ "                    <a href=\"#\">Suspense</a>\r\n"
				+ "                    <a href=\"#\">Drama</a>\r\n"
				+ "                    <a href=\"#\">Açao</a>\r\n"
				+ "                </nav>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div id=\"copy\">\r\n"
				+ "            ©Todos os direitos reservados a | design by <a href=\"https://github.com/camilajasmin\">Camila Jasmin</a></div>\r\n"
				+ "    </footer>\r\n"
				+ "</body>\r\n"
				+ "</html>";
				response.getWriter().append(pagina);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
