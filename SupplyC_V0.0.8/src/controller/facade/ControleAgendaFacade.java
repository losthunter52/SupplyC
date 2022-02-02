package controller.facade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.controller.ControllerEmpresa;
import controller.controller.ControllerItemPedidoJoinItem;
import controller.controller.ControllerPedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Empresa;
import model.ItemPedidoJoinItem;
import model.Pedido;

public class ControleAgendaFacade {

	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private Pedido pedido = new Pedido();
	private ItemPedidoJoinItem itemPedido = new ItemPedidoJoinItem();
	private ArrayList<ItemPedidoJoinItem> itensPedido = new ArrayList<>();
	private ControllerPedido controllerPedidos = new ControllerPedido();
	private ControllerItemPedidoJoinItem controllerItemPedido = new ControllerItemPedidoJoinItem();
	private ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
	private ObservableList<Pedido> dataPedidos = FXCollections.observableArrayList();
	private ObservableList<ItemPedidoJoinItem> dataItemPedido = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public void consultarPedidos() {
		this.controllerPedidos = new ControllerPedido();
		List<Pedido> lista = (List<Pedido>) (List<?>) this.controllerPedidos.getAll();
		if (!pedidos.isEmpty()) {
			pedidos.clear();
		}
		pedidos = (ArrayList<Pedido>) lista;
	}

	@SuppressWarnings("unchecked")
	public void consultarItemPedidos() {
		this.controllerItemPedido = new ControllerItemPedidoJoinItem();
		List<ItemPedidoJoinItem> lista = (List<ItemPedidoJoinItem>) (List<?>) this.controllerItemPedido.getAll();
		if (!itensPedido.isEmpty()) {
			itensPedido.clear();
		}
		itensPedido = (ArrayList<ItemPedidoJoinItem>) lista;
	}

	public ObservableList<Pedido> atualizarListaPedidos() {
		consultarPedidos();
		dataPedidos.clear();
		for (Pedido element : pedidos) {
			dataPedidos.add(new Pedido(element.getIdPedido(), element.getEmpresa_idEmpresa(),
					element.getGrupoPedido_idGrupoPedido(), element.getData(), element.getStatus()));
		}
		return dataPedidos;
	}

	public ObservableList<ItemPedidoJoinItem> atualizarListaItemPedidos(int a) {
		consultarItemPedidos();
		Pedido n = selecionarPedidoIndice(a);
		dataItemPedido.clear();
		for (ItemPedidoJoinItem element : itensPedido) {
			if (element.getPedido_idPedido() == n.getIdPedido()) {
				dataItemPedido.add(new ItemPedidoJoinItem(element.getIdItemPedido(), element.getItem_idItem(),
						element.getPedido_idPedido(), element.getQuantidade(), element.getGrupoPedido_idGrupoPedido(),
						element.getCategoria(), element.getPreco(), element.getDescricao()));
			}
		}
		return dataItemPedido;
	}

	public Pedido selecionarPedidoIndice(int indice) {
		try {
			pedido = (Pedido) controllerPedidos.getPorIndice(indice);
			consultarPedidos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
		return pedido;
	}

	public ItemPedidoJoinItem selecionarItemPedidoIndice(int indice) {
		try {
			itemPedido = (ItemPedidoJoinItem) controllerItemPedido.getPorIndice(indice);
			consultarItemPedidos();
			return itemPedido;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Pedido Vazio:" + e.getMessage());
			return itemPedido;
		}
	}

	public void statusFinalizado(int indice) {
		Pedido aux = selecionarPedidoIndice(indice);
		aux.finalizar();
		Empresa empresa = controllerEmpresa.consultarPorIdEmpresa(aux.getEmpresa_idEmpresa());
		empresa.setAviso("Atenção: \n\n   Pedido: " + aux.getIdPedido() + "\n   Data: " + aux.getData()
				+ "\n   Status: Finalizado\n\n");
		controllerEmpresa.alterarAviso(empresa);
		controllerPedidos.alterar(aux);
	}
	
	public void statusLido(int indice) {
		Pedido aux = selecionarPedidoIndice(indice);
		aux.ler();
		Empresa empresa = controllerEmpresa.consultarPorIdEmpresa(aux.getEmpresa_idEmpresa());
		empresa.setAviso("Atenção: \n\n   Pedido: " + aux.getIdPedido() + "\n   Data: " + aux.getData()
				+ "\n   Status: Lido\n\n");
		controllerEmpresa.alterarAviso(empresa);
		controllerPedidos.alterar(aux);
	}

	public ControleAgendaFacade() {
		super();
	}

	public ControleAgendaFacade(ArrayList<Pedido> pedidos, ArrayList<ItemPedidoJoinItem> itensPedido) {
		super();
		this.pedidos = pedidos;
		this.itensPedido = itensPedido;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<ItemPedidoJoinItem> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ArrayList<ItemPedidoJoinItem> itensPedido) {
		this.itensPedido = itensPedido;
	}
}
