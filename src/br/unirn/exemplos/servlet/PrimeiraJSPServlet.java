package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeiraJSPServlet
 */
@WebServlet("/PrimeiraJSPServlet")
public class PrimeiraJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeiraJSPServlet() {
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


		Date data = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		request.setAttribute("dataFormatada", format.format(data));
		
//		response.sendRedirect(request.getContextPath()+"/exemplos/exemplo_jsp.jsp");
		request.getRequestDispatcher("/exemplos/exemplo_jsp.jsp")
		.forward(request, response);
		
		
	}

}
