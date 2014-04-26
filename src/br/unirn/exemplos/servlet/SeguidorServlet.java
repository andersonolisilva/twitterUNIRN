package br.unirn.exemplos.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.exemplos.dao.SeguidorDao;
import br.unirn.exemplos.dao.UsuarioDao;
import br.unirn.exemplos.dominio.Seguidor;
import br.unirn.exemplos.dominio.Usuario;

/**
 * Servlet implementation class SeguidorServlet
 */
@WebServlet("/SeguidorServlet")
public class SeguidorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguidorServlet() {
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
		
		if(operacao.equals("follow")){
		
			String followId = request.getParameter("followId");
			String usuarioId = request.getParameter("usuarioId");
			
			UsuarioDao usuarioDao = new UsuarioDao();
			
			Usuario usuariologado = new Usuario();
			usuariologado = usuarioDao.findById( Integer.parseInt(usuarioId) );
			
			Usuario usuariofollow = new Usuario();
			usuariofollow = usuarioDao.findById( Integer.parseInt(followId) );
			
			Seguidor seguidor = new Seguidor();
			seguidor.setSeguidor(usuariologado);
			seguidor.setDataCadastro(new Date());
			seguidor.setSeguido(usuariofollow);
			
			SeguidorDao seguidorDao = new SeguidorDao();
			seguidorDao.save(seguidor);
			seguidorDao.close();		
				
			response.sendRedirect(request.getContextPath() + "/sistema/index.jsp");
			
		}else if(operacao.equals("unfollow")){
			
			String followId = request.getParameter("followId");
			String usuarioId = request.getParameter("usuarioId");
			
			UsuarioDao usuarioDao = new UsuarioDao();
			
			Usuario seguidor = new Usuario();
			seguidor = usuarioDao.findById( Integer.parseInt(usuarioId) );
			
			Usuario seguido = new Usuario();
			seguido = usuarioDao.findById( Integer.parseInt(followId) );
			
			SeguidorDao seguidorDao = new SeguidorDao();
			Seguidor seg = (Seguidor) seguidorDao.findBySeguidor(seguidor, seguido);
			if(seg!=null){
				seguidorDao.delete(seg);
				seguidorDao.close();		
			}
					
			response.sendRedirect(request.getContextPath() + "/sistema/index.jsp");
			
		}
		
	}

}
