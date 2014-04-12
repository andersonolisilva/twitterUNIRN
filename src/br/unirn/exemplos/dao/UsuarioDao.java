package br.unirn.exemplos.dao;

import org.hibernate.Query;

import br.unirn.exemplos.dominio.Usuario;

public class UsuarioDao extends AbstractDao<Usuario> {

	public Usuario findById(int id) {
		return (Usuario) DAOFactory.getInstance().getSession()
				.get(Usuario.class, id);
	}

	public Usuario findByLogin(String login) {
		Query q = DAOFactory.getInstance().getSession()
				.createQuery("from Usuario where login = :login");
		q.setString("login", login);

		Usuario u = (Usuario) q.uniqueResult();

		return u;

	}
	
	public Usuario autenticar(String login, String senha){
		
		Query q = DAOFactory.getInstance().getSession()
				  .createQuery("from Usuario where login = :login and senha = :senha");
	    q.setString("login", login);
	    q.setString("senha", senha);
	    
	    Usuario u;
	    if (!(q.uniqueResult()==null)){
	    	u = (Usuario) q.uniqueResult();
	    }else{
	    	u = null;
	    }

	    return u;
	}
	
}
