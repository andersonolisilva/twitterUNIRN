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
 * Servlet implementation class VetorServlet
 */
@WebServlet("/VetorServlet")
public class VetorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VetorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Double> listaVetor = new ArrayList<Double>();
		listaVetor.add(11.9);
		listaVetor.add(12.4);
		listaVetor.add(32.7);
		listaVetor.add(11.2);
		listaVetor.add(9.8);
		listaVetor.add(1.3);
		listaVetor.add(42.1);
		listaVetor.add(10.0);

		request.setAttribute("listaVetor", listaVetor);

		request.getRequestDispatcher("jsp/vetor.jsp")
				.forward(request, response);
	}

}
