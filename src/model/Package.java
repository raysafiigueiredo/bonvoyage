package model;

public class Package {
	private int id_pacote;
	private String nome;
	private String categoria;
	private String condicao;
	private float preco;
	private float promocao;
	private int quantidade;

	public Package() {
		super();
	}

	public Package(int id_pacote, String nome, String categoria, String condicao, float preco, float promocao,
			int quantidade) {
		super();
		this.id_pacote = id_pacote;
		this.nome = nome;
		this.categoria = categoria;
		this.condicao = condicao;
		this.preco = preco;
		this.promocao = promocao;
		this.quantidade = quantidade;
	}

	public int getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(int value) {
		this.id_pacote = value;
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

	public float getPromocao() {
		return promocao;
	}

	public void setPromocao(float value) {
		this.promocao = value;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int value) {
		this.quantidade = value;
	}

	@Override
	public String toString() {
		return "Package [id_pacote=" + id_pacote + ", nome=" + nome + ", categoria=" + categoria + ", condicao="
				+ condicao + ", preco=" + preco + ", promocao=" + promocao + ", quantidade=" + quantidade + "]";
	}

}
