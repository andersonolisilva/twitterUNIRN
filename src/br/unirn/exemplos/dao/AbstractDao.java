package br.unirn.exemplos.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import org.hibernate.Session;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T> implements InterfaceDao<T> {

	protected Session session;
	protected Class<T> clazz;

	public AbstractDao() {
		clazz = (Class<T>) getType();
		session = getSession();
	}

	public void save(T entity) {
		session.save(entity);
	}

	public void update(T entity) {
		session.update(entity);
	}

	public void delete(T entity) {
		session.delete(entity);
	}

	public T find(int id) {
		return (T) session.get(clazz, id);
	}

	public Collection<T> findAll() {
		return session.createQuery("from " + clazz.getSimpleName()).list();
	}

	public Session getSession() {
		if (session == null || !session.isOpen()) {
			//session = DAOFactory.getInstance().openSession();
			session = DAOFactory.getInstance().openSession();
		}
		if (session.getTransaction() == null
				|| !session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		return session;
	}

	public void close() {
		if (session.getTransaction() != null
				&& session.getTransaction().isActive()) {
			session.getTransaction().commit();
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	public void setSession(Session session) {
		this.session = session;
	}

	private Type getType() {
		ParameterizedType superclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return superclass.getActualTypeArguments()[0];
	}
}
