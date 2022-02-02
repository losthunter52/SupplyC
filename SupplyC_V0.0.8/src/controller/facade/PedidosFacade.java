package controller.facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.controller.ControllerItemPedido;
import controller.controller.ControllerItemPedidoJoinItem;
import controller.controller.ControllerPedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemPedido;
import model.ItemPedidoJoinItem;
import model.Pedido;

public class PedidosFacade {

	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private ArrayList<ItemPedidoJoinItem> itensPedido = new ArrayList<>();
	private ItemPedido itemPedido = new ItemPedido();
	private ControllerPedido controllerPedido = new ControllerPedido();
	private ControllerItemPedidoJoinItem controllerItemPedidoJoinItem = new ControllerItemPedidoJoinItem();
	private ControllerItemPedido controllerItemPedido = new ControllerItemPedido();
	private ObservableList<String> dataPedidos = FXCollections.observableArrayList();
	private ObservableList<ItemPedidoJoinItem> dataItemPedido = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public void consultarPedidos() {
		this.controllerPedido = new ControllerPedido();
		List<Pedido> lista = (List<Pedido>) (List<?>) this.controllerPedido.getAll();
		if (!pedidos.isEmpty()) {
			pedidos.clear();
		}
		pedidos = (ArrayList<Pedido>) lista;
	}

	@SuppressWarnings("unchecked")
	public void consultarItemPedidoJoinItem() {
		this.controllerItemPedidoJoinItem = new ControllerItemPedidoJoinItem();
		List<ItemPedidoJoinItem> lista = (List<ItemPedidoJoinItem>) (List<?>) this.controllerItemPedidoJoinItem
				.getAll();
		if (!itensPedido.isEmpty()) {
			itensPedido.clear();
		}
		itensPedido = (ArrayList<ItemPedidoJoinItem>) lista;
	}

	public ObservableList<ItemPedidoJoinItem> selecionaPedido(int index) {
		consultarItemPedidoJoinItem();
		dataItemPedido.clear();
		for (ItemPedidoJoinItem element : itensPedido) {
			if (element.getPedido_idPedido() == index) {
				dataItemPedido.add(new ItemPedidoJoinItem(element.getIdItemPedido(),
						element.getItem_idItem(), element.getPedido_idPedido(),
						element.getQuantidade(), element.getGrupoPedido_idGrupoPedido(),
						element.getCategoria(), element.getPreco(),
						element.getDescricao()));
			}
		}

		return dataItemPedido;
	}

	public ObservableList<String> consultarPedidosPorData(Date data) {
		consultarPedidos();
		dataPedidos.clear();
		for (Pedido element : pedidos) {
			String a = String.valueOf(element.getData());
			String b = String.valueOf(data);
			if (a.contains(b)) {
				dataPedidos.add(new String(element.getIdPedido() + " - " + element.getStatus()));
			}
		}
		return dataPedidos;
	}

	public void zerar() {
		float a = 0;
		for (ItemPedidoJoinItem element : dataItemPedido) {
			alterar(element.getIdItemPedido(), element.getItem_idItem(),
					element.getPedido_idPedido(), a);
		}
	}

	public void salvarSelecionado(int i, float quantidade) {
		alterar(dataItemPedido.get(i).getIdItemPedido(), dataItemPedido.get(i).getItem_idItem(),
				dataItemPedido.get(i).getPedido_idPedido(), quantidade);
	}

	public ItemPedidoJoinItem selecionarItemPedidoPorIndice(int index) {
		ItemPedidoJoinItem aux = new ItemPedidoJoinItem();
		aux.setCategoria(dataItemPedido.get(index).getCategoria());
		aux.setDescricao(dataItemPedido.get(index).getDescricao());
		aux.setQuantidade(dataItemPedido.get(index).getQuantidade());
		return aux;
	}

	public void alterar(int idItemPedido, int item_idItem, int pedido_idPedido, float quantidade) {
		try {
			ItemPedido aux = new ItemPedido();
			aux.setIdItemPedido(idItemPedido);
			aux.setItem_idItem(item_idItem);
			aux.setPedido_idPedido(pedido_idPedido);
			aux.setQuantidade(quantidade);
			controllerItemPedido.alterar(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	public PedidosFacade() {
		super();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ControllerPedido getControllerPedido() {
		return controllerPedido;
	}

	public void setControllerPedido(ControllerPedido controllerPedido) {
		this.controllerPedido = controllerPedido;
	}

	public ControllerItemPedidoJoinItem getControllerItemPedidoJoinItem() {
		return controllerItemPedidoJoinItem;
	}

	public void setControllerItemPedidoJoinItem(ControllerItemPedidoJoinItem controllerItemPedidoJoinItem) {
		this.controllerItemPedidoJoinItem = controllerItemPedidoJoinItem;
	}

	public ControllerItemPedido getControllerItemPedido() {
		return controllerItemPedido;
	}

	public void setControllerItemPedido(ControllerItemPedido controllerItemPedido) {
		this.controllerItemPedido = controllerItemPedido;
	}

	public ObservableList<String> getDataPedidos() {
		return dataPedidos;
	}

	public ObservableList<ItemPedidoJoinItem> getDataItemPedido() {
		return dataItemPedido;
	}

	public void setDataItemPedido(ObservableList<ItemPedidoJoinItem> dataItemPedido) {
		this.dataItemPedido = dataItemPedido;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

}
