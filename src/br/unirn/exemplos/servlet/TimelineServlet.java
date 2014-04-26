package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.exemplos.dao.PostDAO;
import br.unirn.exemplos.dominio.Post;
import br.unirn.exemplos.dominio.Usuario;

/**
 * Servlet implementation class TimelineServlet
 */
@WebServlet("/TimelineServlet")
public class TimelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimelineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");
		String mensagem = request.getParameter("post");
		Usuario usuario = (Usuario) request.getSession().getAttribute(
				"usuarioLogado");

		if (operacao != null && operacao.equals("postar")) {

			PostDAO dao = new PostDAO();
			Post post = new Post();
			post.setDataCadastro(new Date());
			post.setMensagem(mensagem);
			post.setUsuario(usuario);

			dao.save(post);
			dao.close();

		}

		PostDAO daoLista = new PostDAO();
		List<Post> listaPost = (List<Post>) daoLista.getPostByUser(usuario);

		// Em ordem decrescente de post
		Collections.sort(listaPost, new Comparator() {
			public int compare(Object o1, Object o2) {
				Post p1 = (Post) o1;
				Post p2 = (Post) o2;
				return p1.getId() < p2.getId() ? +1
						: (p1.getId() > p2.getId() ? -1 : 0);
			}
		});

		request.setAttribute("listaPost", listaPost);

		request.getRequestDispatcher("/sistema/index.jsp").forward(request,
				response);

		return;

	}
}