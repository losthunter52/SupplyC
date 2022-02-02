package model;

import java.sql.Date;

public class Pedido {

	private int idPedido;
	private int empresa_idEmpresa;
	private int grupoPedido_idGrupoPedido;
	private Date data;
	private String status;

	public Pedido() {
		super();
	}

	public Pedido(int idPedido, int empresa_idEmpresa, int grupoPedido_idGrupoPedido, Date data, String status) {
		super();
		this.idPedido = idPedido;
		this.empresa_idEmpresa = empresa_idEmpresa;
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
		this.data = data;
		this.status = status;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getEmpresa_idEmpresa() {
		return empresa_idEmpresa;
	}

	public void setEmpresa_idEmpresa(int empresa_idEmpresa) {
		this.empresa_idEmpresa = empresa_idEmpresa;
	}

	public int getGrupoPedido_idGrupoPedido() {
		return grupoPedido_idGrupoPedido;
	}

	public void setGrupoPedido_idGrupoPedido(int grupoPedido_idGrupoPedido) {
		this.grupoPedido_idGrupoPedido = grupoPedido_idGrupoPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void finalizar() {
		this.status = "finalizado";
	}
	
	public void ler() {
		this.status = "lido";
	}

	public void criar() {
		this.status = "adicionado";
	}
}
