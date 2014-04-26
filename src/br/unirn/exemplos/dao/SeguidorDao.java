package br.unirn.exemplos.dao;

import java.util.List;

import org.hibernate.Query;

import br.unirn.exemplos.dominio.Seguidor;
import br.unirn.exemplos.dominio.Usuario;

public class SeguidorDao extends AbstractDao<Seguidor>{
	
	public Seguidor findBySeguidor(Usuario seguidor, Usuario seguido){
		
		String sql = "from Seguidor s where seguidor_id = :seguidor_id and seguido_id = :seguido_id ";
		Query pesquisa = DAOFactory.getInstance().getSession()
				.createQuery(sql);
		pesquisa.setInteger("seguidor_id", seguidor.getId());
	    pesquisa.setInteger("seguido_id", seguido.getId());
	    Seguidor seg = (Seguidor)pesquisa.uniqueResult();
	    
		return seg;
	}
	
	public List<Usuario> findByUsuariosSeguidos(Usuario usuario){
		
		String sql = " select distinct u.* " 
				+ "   from Usuario u "   
			    + "   join Seguidor s on ( u.id_usuario = s.seguido_id ) "  
			    + "   where s.seguidor_id = :usuario_id ";
		Query consultaPost = session
				.createSQLQuery(sql)
				.addEntity("u.*",Usuario.class)	        
				.setParameter("usuario_id", usuario.getId());
		
		List<Usuario> list = consultaPost.list();
		return list;
	}

}
