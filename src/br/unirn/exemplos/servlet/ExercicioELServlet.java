package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExercicioELServlet
 */
@WebServlet("/ExercicioELServlet")
public class ExercicioELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExercicioELServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String valorA = request.getParameter("valor1");
		String valorB = request.getParameter("valor2");
		
		List<Double> listaVetor = new ArrayList<Double>();
		listaVetor.add(10.9);
		listaVetor.add(1.3);
		listaVetor.add(23.4);
				
		request.setAttribute("valorA", valorA);
		request.setAttribute("valorB", valorB);
		request.setAttribute("listaVetor", listaVetor);
		
		request.getRequestDispatcher("jsp/ExercicioEL.jsp").forward(request, response);
	}

}
