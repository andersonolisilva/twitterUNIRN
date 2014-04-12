package br.unirn.exemplos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeuPrimeiroServlet
 */
@WebServlet("/MeuPrimeiroServlet")
public class MeuPrimeiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeuPrimeiroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//escreve resposta no writer e exibe página HTML criada.
//		PrintWriter out = response.getWriter();
//		
//		out.write("<html>");
//		out.write("<body>");
//		out.write("<h1>Meu Primeiro Servlet</h1>");
//		out.println(new Date());
//		out.write("</body>");
//		out.write("</html>");
//		
//		out.close();
		
		//encaminhando requisicao para outra URL
//		request.getRequestDispatcher("exemplo_html.html")
//		.forward(request, response);
		
		//redireciona para a Pagina abaixo
		response.sendRedirect("exemplo_html.html");
		return;
	}

}
