package br.unirn.exemplos.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Seguidor {

	@Id
	@SequenceGenerator(name = "public.seguidor_sequence", initialValue = 1, allocationSize = 1, sequenceName = "public.seguidor_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.seguidor_sequence")
	@Column(name = "id_seguidor")
	private int id;

	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@ManyToOne
	@JoinColumn(name = "seguidor_id")
	private Usuario seguidor;

	@ManyToOne
	@JoinColumn(name = "seguido_id")
	private Usuario seguido;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getSeguido() {
		return seguido;
	}

	public void setSeguido(Usuario seguido) {
		this.seguido = seguido;
	}


}
