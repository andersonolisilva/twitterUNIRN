package br.unirn.exemplos.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.unirn.exemplos.dao.LogDao;
import br.unirn.exemplos.dominio.LogAcesso;
import br.unirn.exemplos.dominio.Usuario;

/**
 * Servlet Filter implementation class LogAcessoFilter
 */
@WebFilter(urlPatterns="/*",filterName="LogAcessoFilter",servletNames={"LoginServlet"})
public class LogAcessoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogAcessoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		if (session != null){
			LogAcesso log = new LogAcesso();

			log.setPathInfo(req.getRequestURI());
			
			log.setUserAgent(req.getHeader("user-agent"));

			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			
			if (usuario != null ){
				log.setLoginUsuario(usuario.getLogin());
			}
			log.setDataAcesso(new Date());
			
			LogDao sessionDao = new LogDao();
			sessionDao.save(log);
			sessionDao.close();

		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
