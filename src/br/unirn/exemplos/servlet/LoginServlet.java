package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.exemplos.dao.UsuarioDao;
import br.unirn.exemplos.dominio.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		if (operacao.equals("logar")) {

			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			if (!(login.equals("") || senha.equals(""))) {
				HttpSession session = request.getSession(true);
				UsuarioDao dao = new UsuarioDao();

				Usuario usuario = dao.autenticar(login, senha);

				if (usuario == null) {
					loginSemSucesso(response);
				} else {
					session.setAttribute("usuarioLogado", usuario);

					loginComSucesso(request, response);
				}
				dao.close();

			} else {
				loginSemSucesso(response);
			}

		} else if (operacao.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect(request.getContextPath() + "/index.html");
		}
		return;
		// response.sendRedirect(request.getContextPath()+"/index.html");

	}

	private void loginSemSucesso(HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();

		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='ISO-8859-1'>");
		out.write("<title>WEB I - Tente novamente</title>");
		out.write("<link rel='stylesheet' type='text/css' href='/twitterUNIRN/css/interno.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		out.write("<h1>Usuário e/ou senha incorreto(os)!</h1>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");

		out.close();

	}

	private void loginComSucesso(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("TimelineServlet").forward(request, response);
		
		return;
	}

}
