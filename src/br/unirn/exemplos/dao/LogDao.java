package br.unirn.exemplos.dao;

import br.unirn.exemplos.dominio.LogAcesso;

public class LogDao extends AbstractDao<LogAcesso> {

	public LogAcesso findById(int id) {
		return (LogAcesso) DAOFactory.getInstance().getSession()
				.get(LogAcesso.class, id);
	}
}
