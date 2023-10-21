package model;

import java.util.Date;

public class Passenger {
	private int id_passageiro;
	private String nome;
	private Date nascimento;
	private int documento;
	private String genero;
	private String telefone;
	private String email;
	private String senha;
	private boolean cadastrado, logado;

	public Passenger() {
		super();
	}

	public Passenger(int id_passageiro, String nome, Date nascimento, int documento, String genero, String telefone,
			String email, String senha, boolean cadastrado, boolean logado) {
		super();
		this.id_passageiro = id_passageiro;
		this.nome = nome;
		this.nascimento = nascimento;
		this.documento = documento;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.cadastrado = cadastrado;
		this.logado = logado;
	}

	public int getId_passageiro() {
		return id_passageiro;
	}

	public void setId_passageiro(int id_passageiro) {
		this.id_passageiro = id_passageiro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public boolean isCadastrado() {
		return cadastrado;
	}

	public void setCadastrado(boolean cadastrado) {
		this.cadastrado = cadastrado;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	@Override
	public String toString() {
		return "Passenger [id_passageiro=" + id_passageiro + ", nome=" + nome + ", nascimento=" + nascimento
				+ ", documento=" + documento + ", genero=" + genero + ", telefone=" + telefone + ", email=" + email
				+ ", senha=" + senha + ", cadastrado=" + cadastrado + ", logado=" + logado + "]";
	}

}