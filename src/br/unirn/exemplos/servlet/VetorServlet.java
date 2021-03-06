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
		List<Double> listaVetor = new ArrayList<Double>();
		listaVetor.add(5.9);
		listaVetor.add(15.9);
		listaVetor.add(54.9);
		listaVetor.add(34.9);
		listaVetor.add(9.9);
		listaVetor.add(54.9);
		listaVetor.add(8.9);
		listaVetor.add(9.9);
		
		request.setAttribute("listaVetor", listaVetor);
		
		request.getRequestDispatcher("jsp/vetor.jsp").forward(request, response);
	}

}
