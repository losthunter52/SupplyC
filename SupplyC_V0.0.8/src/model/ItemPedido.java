package model;

public class ItemPedido {

	private int idItemPedido;
	private int item_idItem;
	private int pedido_idPedido;
	private float quantidade;

	public ItemPedido(int idItemPedido, int item_idItem, int pedido_idPedido, float quantidade) {
		super();
		this.idItemPedido = idItemPedido;
		this.item_idItem = item_idItem;
		this.pedido_idPedido = pedido_idPedido;
		this.quantidade = quantidade;
	}

	public ItemPedido() {
		super();
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

}
