package model;

public class Item {

	private int idItem;
	private int grupoPedido_idGrupoPedido;
	private String categoria;
	private float preco;
	private String descricao;

	public Item(int idItem, int grupoPedido_idGrupoPedido, String categoria, float preco, String descricao) {
		super();
		this.idItem = idItem;
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
	}

	public Item() {
		super();
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getGrupoPedido_idGrupoPedido() {
		return grupoPedido_idGrupoPedido;
	}

	public void setGrupoPedido_idGrupoPedido(int grupoPedido_idGrupoPedido) {
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
