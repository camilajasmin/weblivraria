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
		String pagina ="<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
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
				+ "    }\r\n"
			    +"    #listalivros{\r\n"
			    + "        display: inline-flexbox;        \r\n"
			    + "        flex-wrap: wrap;\r\n"
			    + "        width: 70%;\r\n"
			    + "        margin-left: auto;\r\n"
			    + "        margin-right: auto;\r\n"
			    + "        justify-content: center ;\r\n"
			    + "   }\r\n"
			    + "\r\n"
			    + "   .livro{\r\n"
			    + "        width: 20%;\r\n"
			    + "        border: 1px solid silver;\r\n"
			    + "        padding: 50px;\r\n"
			    + "\r\n"
			    + "        }   \r\n"
			    + "\r\n"
			    + "    .livro img{\r\n"
			    + "        width: 100%;\r\n"
			    + "\r\n"
			    + "        }\r\n"
			    + "\r\n"
			    + "    .livro h4{\r\n"
			    + "        font-family: candara;\r\n"
			    + "        font-size: 14pt;\r\n"
			    + "    }\r\n"
			    + "\r\n"
			    + "    .livro p{\r\n"
			    + "        font-family: candara;\r\n"
			    + "        font-size: 15px;\r\n"
			    + "    }"
			    + ".detalhe{\r\n"
			    + "    display: flex;\r\n"
			    + "    width: 1000px;\r\n"
			    + "    margin-left: auto;\r\n"
			    + "    margin-right: auto;\r\n"
			    + "}\r\n"
			    + "\r\n"
			    + ".detalhe img{\r\n"
			    + "    width: 500px;\r\n"
			    + "    height: 600px;\r\n"
			    + "}\r\n"
			    + "\r\n"
			    + ".detalhe .item{\r\n"
			    + "    padding:20px;\r\n"
			    + "\r\n"
			    + "}\r\n"
			    + "\r\n"
			    + ".detalhe .item h4{\r\n"
			    + "    font-family: Arial, Helvetica, sans-serif;\r\n"
			    + "    font-size: 20pt;\r\n"
			    + "}\r\n"
			    + "\r\n"
			    + ".detalhe .item h5{\r\n"
			    + "    margin: 0px;\r\n"
			    + "    font-family:arial;\r\n"
			    + "    font-size: 10pt;\r\n"
			    + "}\r\n"
			    + "\r\n"
			    + ".detalhe .item .sinopse{\r\n"
			    + "    font-family: arial;\r\n"
			    + "    font-size: 15px;\r\n"
			    + "    line-height: 15pt;\r\n"
			    + "}"
			    + ".detalhe .item .preco{\r\n"
			    + "    font-family: arial;\r\n"
			    + "    font-weight: bold;\r\n"
			    + "    color: olivedrab;\r\n"
			    + "    font-size: 20px;\r\n"
			    +"     animation: moveText 2s infinite alternate"
			    + "}"
			    + "	   .detalhe a{"
				+ "    background-color: black;"
				+ "    color: white;"
				+ "    padding: 15px;"
				+ "    text-decoration:none;"
				+ "    font-family: arial;"
				+ "    }"
				+ "</style>\r\n"
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
				String livroId = request.getParameter("id");
                String conteudo="";
                DAOlivro dlivro = new DAOlivro();
                LIVRO liv = new LIVRO();
                
                liv.setIDlivro(Integer.parseInt(livroId));
                
                liv = dlivro.pesquisar(liv);
   
                conteudo+="<div class=\"detalhe\">\r\n"
                +"                <img src="+liv.getCAPAlivro()+" alt=\"\">\r\n"
                +" <div class=item> <h4>"+liv.getTITULOlivro()+"</h4>\r\n"
                +"                <h5>"+liv.getAUTORlivro()+"</h5>\r\n"
                +"                <h5>"+liv.getGENEROlivro()+"</h5>\r\n"
                +"                <p class = sinopse>"+liv.getSINOPSElivro()+"</P>\r\n"
                +"                <p class=\"preco\"> R$ "+liv.getPRECOlivro()+"</p>"
                +"				  <a href = ServicePagamento?id="+liv.getIDlivro()+" class=pag>Ir para pagamento</a></div>\r\n"
                +"            </div></a>\r\n"
                ;
                
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
