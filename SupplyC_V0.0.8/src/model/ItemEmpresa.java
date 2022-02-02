package model;

public class ItemEmpresa {

	private int idItemEmpresa;
	private int empresa_idEmpresa;
	private int item_idItem;
	private Boolean associado;

	public ItemEmpresa() {
		super();
	}

	public ItemEmpresa(int idItemEmpresa, int empresa_idEmpresa, int item_idItem, Boolean associado) {
		super();
		this.idItemEmpresa = idItemEmpresa;
		this.empresa_idEmpresa = empresa_idEmpresa;
		this.item_idItem = item_idItem;
		this.associado = associado;
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

}
