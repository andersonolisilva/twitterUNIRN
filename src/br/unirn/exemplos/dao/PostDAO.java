package br.unirn.exemplos.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import br.unirn.exemplos.dominio.Post;
import br.unirn.exemplos.dominio.Usuario;


public class PostDAO extends AbstractDao<Post> {
	
	@SuppressWarnings("unchecked")
	public Collection<Post> getPostByUser(Usuario usuario){

		String sql = "select p.* from Post p "
			    + " where usuario_id = :usuario_id "
				+ " union "
				+ " select distinct p.* " 
				+ "   from Post p   "
			    + "  join Usuario u on ( p.usuario_id = u.id_usuario ) "   
			    + "   join Seguidor s on ( u.id_usuario = s.seguido_id ) "  
			    + "   where s.seguidor_id = :usuario_id ";
		Query consultaPost = session
				.createSQLQuery(sql)
				.addEntity("p.*",Post.class)	        
				.setParameter("usuario_id", usuario.getId());
		
		List<Post> list = consultaPost.list();
		return list;
	}

}
