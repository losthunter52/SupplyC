package controller.facade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.controller.ControllerItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.GrupoPedido;
import model.Item;

public class ControleItemFacade {

	private ArrayList<Item> listaItem;
	private ArrayList<GrupoPedido> grupoPedido;
	private ArrayList<String> categoria;
	private Item item;
	private ControllerItem controllerItem;
	private ObservableList<Item> data;

	public ControleItemFacade() {
		super();
		this.listaItem = new ArrayList<>();
		this.grupoPedido = new ArrayList<>();
		this.setCategoria(new ArrayList<>());
		this.item = new Item();
		this.controllerItem = new ControllerItem();
		this.data = FXCollections.observableArrayList();
	}

	public void salvar(int idGrupoPedido, String categoria, float preco, String descricao) {

		try {
			item.setIdItem(0);
			item.setGrupoPedido_idGrupoPedido(idGrupoPedido);
			item.setCategoria(categoria);
			item.setPreco(preco);
			item.setDescricao(descricao);
			controllerItem.inserir(item);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}

	}

	public void alterar(int idItem, int idGrupoPedido, String categoria, float preco, String descricao) {
		try {
			Item aux = (Item) controllerItem.getPorIndice(idItem);
			aux.setGrupoPedido_idGrupoPedido(idGrupoPedido);
			aux.setCategoria(categoria);
			aux.setPreco(preco);
			aux.setDescricao(descricao);
			controllerItem.alterar(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	public void excluir(int idItem, int idGrupoPedido, String categoria, float preco, String descricao) {
		try {
			Item aux = (Item) controllerItem.getPorIndice(idItem);
			controllerItem.excluir(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void consultar() {
		this.controllerItem = new ControllerItem();
		List<Item> lista = (List<Item>) (List<?>) this.controllerItem.getAll();
		if (!listaItem.isEmpty()) {
			listaItem.clear();
		}
		listaItem = (ArrayList<Item>) lista;
	}

	public ObservableList<Item> atualizarLista() {
		consultar();
		data.clear();
		for (Item element : listaItem) {
			data.add(new Item(element.getIdItem(), element.getGrupoPedido_idGrupoPedido(),
					element.getCategoria(), element.getPreco(), element.getDescricao()));
		}
		return data;
	}

	public Item selecionarIndice(int indice) {
		try {
			item = (Item) controllerItem.getPorIndice(indice);
			consultar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
		return item;
	}

	public ArrayList<Item> getListaItem() {
		return listaItem;
	}

	public void setListaItem(ArrayList<Item> listaItem) {
		this.listaItem = listaItem;
	}

	public ArrayList<GrupoPedido> getGrupoPedido() {
		return grupoPedido;
	}

	public void setGrupoPedido(ArrayList<GrupoPedido> grupoPedido) {
		this.grupoPedido = grupoPedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ControllerItem getControllerItem() {
		return controllerItem;
	}

	public void setControllerItem(ControllerItem controllerItem) {
		this.controllerItem = controllerItem;
	}

	public ObservableList<Item> getData() {
		return data;
	}

	public void setData(ObservableList<Item> data) {
		this.data = data;
	}

	public ArrayList<String> getCategoria() {
		return categoria;
	}

	public void setCategoria(ArrayList<String> categoria) {
		this.categoria = categoria;
	}

}
