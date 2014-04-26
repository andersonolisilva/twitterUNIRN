package br.unirn.exemplos.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Usuario {

	@Id
	@SequenceGenerator(name="public.usuario_sequence",initialValue=1,
	allocationSize=1,sequenceName="public.usuario_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="public.usuario_sequence")
	@Column(name="id_usuario")
	private int id;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	private String descricaoPessoal;
	
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@OneToMany(mappedBy="usuario")
	private List<Post> posts;

	@OneToMany(mappedBy="seguidor")
	private List<Seguidor> seguidor;

	@OneToMany(mappedBy="seguido")
	private List<Seguidor> seguido;
	
	public List<Seguidor> getSeguido() {
		return seguido;
	}

	public void setSeguido(List<Seguidor> seguido) {
		this.seguido = seguido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoPessoal() {
		return descricaoPessoal;
	}

	public void setDescricaoPessoal(String descricaoPessoal) {
		this.descricaoPessoal = descricaoPessoal;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Seguidor> getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(List<Seguidor> seguidor) {
		this.seguidor = seguidor;
	}
	
	
}
