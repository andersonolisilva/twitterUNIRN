package br.unirn.exemplos.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author RAUL
 *
 */
@Entity
@Table(name="log_acesso")
public class LogAcesso {

	@Id
	@Column(name="id_log_acesso")
	@GenericGenerator(name="public.log_seq",strategy="sequence")
	@GeneratedValue(generator="public.log_seq")
	int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_acesso")
	Date dataAcesso;
	
	@Column(name="path_info")
	String pathInfo;
	
	@Column(name="user_agent")
	String userAgent;
	
	@Column(name="login_usuario")
	String loginUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	public String getPathInfo() {
		return pathInfo;
	}

	public void setPathInfo(String pathInfo) {
		this.pathInfo = pathInfo;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	

}
