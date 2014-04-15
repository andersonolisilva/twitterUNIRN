package br.unirn.exemplos.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import br.unirn.exemplos.dominio.Post;
import br.unirn.exemplos.dominio.Usuario;


public class PostDAO extends AbstractDao<Post> {
	
	@SuppressWarnings("unchecked")
	public Collection<Post> getPostByUser(Usuario usuario){
		Query consultaPost = session.createQuery("from Post p where usuario_id = :usuario_id order by id desc");
		consultaPost.setParameter("usuario_id", usuario.getId());
		List<Post> list = consultaPost.list();
		return list;
	}

}
