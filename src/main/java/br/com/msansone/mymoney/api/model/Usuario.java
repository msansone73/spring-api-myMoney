package br.com.msansone.mymoney.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max = 200, min = 10)
	@Column(name = "nome", nullable = false, scale = 200)
	private String nome;
	
	@Size(max = 200, min = 10)
	@Column(name = "email", nullable = false, scale = 200)
	private String email;

	@Size(max = 200, min = 2)
	@Column(name = "senha", nullable = false, scale = 200)
	private String senha;

	@Column(name = "perfil", nullable = false)
	private PerfilType perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilType getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilType perfil) {
		this.perfil = perfil;
	}
	

	
}

