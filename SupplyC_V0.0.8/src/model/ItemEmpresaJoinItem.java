package model;

public class ItemEmpresaJoinItem {

	private int idItemEmpresa;
	private int empresa_idEmpresa;
	private int item_idItem;
	private Boolean associado;
	private int grupoPedido_idGrupoPedido;
	private String categoria;
	private float preco;
	private String descricao;
	private float quantidade = 0;

	public ItemEmpresaJoinItem() {
		super();
	}

	public ItemEmpresaJoinItem(int idItemEmpresa, int empresa_idEmpresa, int item_idItem, Boolean associado,
			int grupoPedido_idGrupoPedido, String categoria, float preco, String descricao, float quantidade) {
		super();
		this.idItemEmpresa = idItemEmpresa;
		this.empresa_idEmpresa = empresa_idEmpresa;
		this.item_idItem = item_idItem;
		this.associado = associado;
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public ItemEmpresaJoinItem(int idItemEmpresa, int empresa_idEmpresa, int item_idItem, Boolean associado,
			int grupoPedido_idGrupoPedido, String categoria, float preco, String descricao) {
		super();
		this.idItemEmpresa = idItemEmpresa;
		this.empresa_idEmpresa = empresa_idEmpresa;
		this.item_idItem = item_idItem;
		this.associado = associado;
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = 0;
	}

	public int getIdItemEmpresa() {
		return idItemEmpresa;
	}

	public void setIdItemEmpresa(int idItemEmpresa) {
		this.idItemEmpresa = idItemEmpresa;
	}

	public int getEmpresa_idEmpresa() {
		return empresa_idEmpresa;
	}

	public void setEmpresa_idEmpresa(int empresa_idEmpresa) {
		this.empresa_idEmpresa = empresa_idEmpresa;
	}

	public int getItem_idItem() {
		return item_idItem;
	}

	public void setItem_idItem(int item_idItem) {
		this.item_idItem = item_idItem;
	}

	public Boolean getAssociado() {
		return associado;
	}

	public void setAssociado(Boolean associado) {
		this.associado = associado;
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

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

}
