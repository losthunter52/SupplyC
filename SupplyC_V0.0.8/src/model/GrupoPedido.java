package model;

public class GrupoPedido {

	private int idGrupoPedido;
	private String descricao;
	private String tipo;

	public GrupoPedido() {
		super();
	}

	public GrupoPedido(int idGrupoPedido, String descricao, String tipo) {
		super();
		this.idGrupoPedido = idGrupoPedido;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public int getIdGrupoPedido() {
		return idGrupoPedido;
	}

	public void setIdGrupoPedido(int idGrupoPedido) {
		this.idGrupoPedido = idGrupoPedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
