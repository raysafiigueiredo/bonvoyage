package model;

public class Destination {
	private int id_destino;
	private String nome;
	private String categoria;
	private String condicao;
	private float preco;
	private int quantidade;

	public Destination() {
		super();
	}

	public Destination(int id, String nome, String categoria, String condicao, float preco, int quantidade) {
		super();
		this.id_destino = id;
		this.nome = nome;
		this.categoria = categoria;
		this.condicao = condicao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int value) {
		this.id_destino = value;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String value) {
		this.nome = value;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String value) {
		this.categoria = value;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String value) {
		this.condicao = value;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float value) {
		this.preco = value;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int value) {
		this.quantidade = value;
	}

	@Override
	public String toString() {
		return "Destination [id_destino=" + id_destino + ", nome=" + nome + ", categoria=" + categoria + ", condicao="
				+ condicao + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}

}
