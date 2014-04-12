package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.util.Date;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String operacao = request.getParameter("operacao");
		String mensagem = request.getParameter("post");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		if (operacao != null && operacao.equals("postar")){

			/*@SuppressWarnings("unchecked")
			List<String> tweets = (List<String>) request.getSession().getAttribute("tweets");

			if (tweets == null){
				tweets = new ArrayList<String>();
			}

			tweets.add(request.getParameter("post"));

			request.getSession().setAttribute("tweets", tweets);

			//request.getRequestDispatcher(request.getContextPath()+"/sistema/timeline.html").forward(request, response);
*/			
			
			PostDAO dao = new PostDAO();
			Post post = new Post();
			post.setDataCadastro(new Date());
			post.setMensagem(mensagem);
			post.setUsuario(usuario);
			
			dao.save(post);
			dao.close();
			
			response.sendRedirect(request.getContextPath() + "/sistema/index.jsp");
			
		}
		return;

	}

	
}
