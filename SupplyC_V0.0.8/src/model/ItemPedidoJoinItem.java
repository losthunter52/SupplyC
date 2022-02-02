package model;

public class ItemPedidoJoinItem {

	private int idItemPedido;
	private int item_idItem;
	private int pedido_idPedido;
	private float quantidade;
	private int grupoPedido_idGrupoPedido;
	private String categoria;
	private float preco;
	private String descricao;

	public ItemPedidoJoinItem() {
		super();
	}

	public ItemPedidoJoinItem(int idItemPedido, int item_idItem, int pedido_idPedido, float quantidade,
			int grupoPedido_idGrupoPedido, String categoria, float preco, String descricao) {
		super();
		this.idItemPedido = idItemPedido;
		this.item_idItem = item_idItem;
		this.pedido_idPedido = pedido_idPedido;
		this.quantidade = quantidade;
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getItem_idItem() {
		return item_idItem;
	}

	public void setItem_idItem(int item_idItem) {
		this.item_idItem = item_idItem;
	}

	public int getPedido_idPedido() {
		return pedido_idPedido;
	}

	public void setPedido_idPedido(int pedido_idPedido) {
		this.pedido_idPedido = pedido_idPedido;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
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
