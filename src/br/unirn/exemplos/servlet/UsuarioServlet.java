package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.exemplos.dao.UsuarioDao;
import br.unirn.exemplos.dominio.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
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
		String operacao = request.getParameter("operacao");
		
		if (operacao.equals("cadastrar")) {

			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String mensagemCadastro;
			
			if (nome.equals("") || login.equals("") || senha.equals("") || descricao.equals("")
					|| nome.equals("Nome de usuário") || login.equals("Login") || senha.equals("Senha") ){
				// testar se algum dos campos foi passado em branco e não permitir
				mensagemCadastro = "Todos os campos são obrigatórios para este cadastro.";
				request.getSession().setAttribute("mensagemCadastro", mensagemCadastro);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}else{
				// testar se o usuário já existe e não permitir
				UsuarioDao usuarioDao = new UsuarioDao();
				Usuario usuario = (Usuario) usuarioDao.findByLogin(login);
				
				if(usuario!=null){
					mensagemCadastro = "O login informado já existe. <br /> Favor informar outro login.";
					request.getSession().setAttribute("mensagemCadastro", mensagemCadastro);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					return;
				}
				
			}
			
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setDescricaoPessoal(descricao);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setDataCadastro(new Date());
			usuarioDao.save(usuario);
			usuarioDao.close();
						
			mensagemCadastro = "Um novo login foi criado. <br /> Confirme os dados a direita para acessar o sistema.";
			request.getSession().setAttribute("mensagemCadastro", mensagemCadastro);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
			
			
		} else if(operacao.equals("buscarUsuario")){
			
			String texto = request.getParameter("texto");
			
			UsuarioDao usuarioDao = new UsuarioDao();
			List<Usuario> buscarUsuario = usuarioDao.findByBuscarUsuario(texto);
	
			HttpSession session = request.getSession(true);
			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			usuario = dao.findById(usuario.getId());
			session.setAttribute("usuarioLogado", usuario);
			
			request.getSession().setAttribute("buscarUsuario", buscarUsuario);
			
			request.getRequestDispatcher("/sistema/buscarusuario.jsp").forward(request, response);
			
			return;
		}
	}

}
