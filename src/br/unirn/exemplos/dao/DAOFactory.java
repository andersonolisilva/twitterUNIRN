package br.unirn.exemplos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Fábrica de sessoes para acesso a banco de dados
 * @author RAUL
 *
 */
public class DAOFactory {
	
	private static DAOFactory singleton;
	private SessionFactory sf;
	
	private Transaction tx;
	
	private Session session;
	
	private DAOFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}

	public static DAOFactory getInstance() {
		if ( singleton == null ) {
			singleton = new DAOFactory();
		}
		return singleton;
	}

	public Session openSession() {		
		return sf.openSession();
	}
	
	public Session getSession(){
		
        session = getInstance().openSession();
        
        tx = session.getTransaction();
		if (tx == null || !tx.isActive()) {
            session.beginTransaction();
        }
        return session;
	}
	
	public void close(){
		tx.commit();
		session.close();
	}
}