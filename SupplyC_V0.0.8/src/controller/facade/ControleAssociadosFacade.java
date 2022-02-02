package controller.facade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.controller.ControllerEmpresa;
import controller.controller.ControllerItemEmpresa;
import controller.controller.ControllerItemEmpresaJoinItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Empresa;
import model.ItemEmpresa;
import model.ItemEmpresaJoinItem;

public class ControleAssociadosFacade {

	private ArrayList<ItemEmpresaJoinItem> itensEmpresa = new ArrayList<>();
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private ItemEmpresa itemEmpresa = new ItemEmpresa();
	private ControllerItemEmpresaJoinItem controllerItemEmpresaJoinItem = new ControllerItemEmpresaJoinItem();
	private ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
	private ControllerItemEmpresa controllerItemEmpresa = new ControllerItemEmpresa();
	private ObservableList<ItemEmpresaJoinItem> data = FXCollections.observableArrayList();
	private ObservableList<String> empresaData = FXCollections.observableArrayList();

	public ControleAssociadosFacade() {
		super();
	}

	public ControleAssociadosFacade(ArrayList<ItemEmpresaJoinItem> itensEmpresa, ArrayList<Empresa> empresas,
			ItemEmpresa itemEmpresa, ControllerItemEmpresaJoinItem controllerItemEmpresaJoinItem,
			ControllerEmpresa controllerEmpresa, ControllerItemEmpresa controllerItemEmpresa) {
		super();
		this.itensEmpresa = itensEmpresa;
		this.empresas = empresas;
		this.itemEmpresa = itemEmpresa;
		this.controllerItemEmpresaJoinItem = controllerItemEmpresaJoinItem;
		this.controllerEmpresa = controllerEmpresa;
		this.controllerItemEmpresa = controllerItemEmpresa;
	}

	public void alterar(int idTable1, int Empresa_idEmpresa, int Item_idItem, Boolean associado) {
		try {
			ItemEmpresa aux = new ItemEmpresa();
			aux.setIdItemEmpresa(idTable1);
			aux.setEmpresa_idEmpresa(Empresa_idEmpresa);
			aux.setItem_idItem(Item_idItem);
			aux.setAssociado(associado);
			controllerItemEmpresa.alterar(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	public void salvar() {
		for (ItemEmpresaJoinItem element : data) {
			alterar(element.getIdItemEmpresa(), element.getEmpresa_idEmpresa(), element.getItem_idItem(),
					element.getAssociado());
		}
	}

	public void excluir(int idTable1, int Empresa_idEmpresa, int Item_idItem, Boolean associado) {
		try {
			ItemEmpresa aux = (ItemEmpresa) controllerItemEmpresa.getPorIndice(idTable1);
			aux.setEmpresa_idEmpresa(Empresa_idEmpresa);
			aux.setItem_idItem(Item_idItem);
			aux.setAssociado(false);
			controllerItemEmpresa.alterar(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void consultar() {
		this.controllerItemEmpresaJoinItem = new ControllerItemEmpresaJoinItem();
		List<ItemEmpresaJoinItem> lista = (List<ItemEmpresaJoinItem>) (List<?>) this.controllerItemEmpresaJoinItem
				.getAll();
		if (!itensEmpresa.isEmpty()) {
			itensEmpresa.clear();
		}
		itensEmpresa = (ArrayList<ItemEmpresaJoinItem>) lista;
		this.controllerEmpresa = new ControllerEmpresa();
		List<Empresa> list = (List<Empresa>) (List<?>) this.controllerEmpresa.getAll();
		if (!empresas.isEmpty()) {
			empresas.clear();
		}
		empresas = (ArrayList<Empresa>) list;
	}

	@SuppressWarnings("unchecked")
	public void consultarWhere(int a) {
		controllerItemEmpresaJoinItem.consultarWhere(new ItemEmpresaJoinItem(), a);
		List<ItemEmpresaJoinItem> lista = (List<ItemEmpresaJoinItem>) (List<?>) this.controllerItemEmpresaJoinItem
				.getAll();
		if (!itensEmpresa.isEmpty()) {
			itensEmpresa.clear();
		}
		itensEmpresa = (ArrayList<ItemEmpresaJoinItem>) lista;
		this.controllerEmpresa = new ControllerEmpresa();
		List<Empresa> list = (List<Empresa>) (List<?>) this.controllerEmpresa.getAll();
		if (!empresas.isEmpty()) {
			empresas.clear();
		}
		empresas = (ArrayList<Empresa>) list;
	}

	public ObservableList<ItemEmpresaJoinItem> atualizarLista(int a) {
		consultarWhere(a);
		data.clear();
		for (ItemEmpresaJoinItem element : itensEmpresa) {
			data.add(new ItemEmpresaJoinItem(element.getIdItemEmpresa(),
					element.getEmpresa_idEmpresa(), element.getItem_idItem(),
					element.getAssociado(), element.getGrupoPedido_idGrupoPedido(),
					element.getCategoria(), element.getPreco(),
					element.getDescricao(), element.getQuantidade()));
		}
		return data;
	}

	public ObservableList<String> atualizarEmpresas() {
		consultar();
		empresaData.clear();
		for (Empresa element : empresas) {
			empresaData.add(new String(element.getIdEmpresa() + " - " + element.getDescricao()));
		}
		return empresaData;
	}

	public ObservableList<ItemEmpresaJoinItem> marcarTodos(Boolean bol) {
		for (ItemEmpresaJoinItem element : data) {
			element.setAssociado(true);
		}
		return data;
	}

	public ObservableList<ItemEmpresaJoinItem> marcarSelecionado(Boolean bol, int index) {
		data.clear();
		for (int i = 0; i < itensEmpresa.size(); i++) {
			if (i == index) {
				data.add(new ItemEmpresaJoinItem(itensEmpresa.get(i).getIdItemEmpresa(),
						itensEmpresa.get(i).getEmpresa_idEmpresa(), itensEmpresa.get(i).getItem_idItem(), bol,
						itensEmpresa.get(i).getGrupoPedido_idGrupoPedido(), itensEmpresa.get(i).getCategoria(),
						itensEmpresa.get(i).getPreco(), itensEmpresa.get(i).getDescricao(),
						itensEmpresa.get(i).getQuantidade()));
			} else {
				data.add(new ItemEmpresaJoinItem(itensEmpresa.get(i).getIdItemEmpresa(),
						itensEmpresa.get(i).getEmpresa_idEmpresa(), itensEmpresa.get(i).getItem_idItem(),
						itensEmpresa.get(i).getAssociado(), itensEmpresa.get(i).getGrupoPedido_idGrupoPedido(),
						itensEmpresa.get(i).getCategoria(), itensEmpresa.get(i).getPreco(),
						itensEmpresa.get(i).getDescricao(), itensEmpresa.get(i).getQuantidade()));
			}
		}

		return data;
	}

	public ItemEmpresa selecionarIndice(int indice) {
		try {
			itemEmpresa = (ItemEmpresa) controllerItemEmpresa.getPorIndice(indice);
			consultar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
		return itemEmpresa;
	}

	public ArrayList<ItemEmpresaJoinItem> getItensEmpresa() {
		return itensEmpresa;
	}

	public void setItensEmpresa(ArrayList<ItemEmpresaJoinItem> itensEmpresa) {
		this.itensEmpresa = itensEmpresa;
	}

	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}

	public ItemEmpresa getItemEmpresa() {
		return itemEmpresa;
	}

	public void setItemEmpresa(ItemEmpresa itemEmpresa) {
		this.itemEmpresa = itemEmpresa;
	}

	public ControllerItemEmpresaJoinItem getControllerItemEmpresaJoinItem() {
		return controllerItemEmpresaJoinItem;
	}

	public void setControllerItemEmpresaJoinItem(ControllerItemEmpresaJoinItem controllerItemEmpresaJoinItem) {
		this.controllerItemEmpresaJoinItem = controllerItemEmpresaJoinItem;
	}

	public ControllerEmpresa getControllerEmpresa() {
		return controllerEmpresa;
	}

	public void setControllerEmpresa(ControllerEmpresa controllerEmpresa) {
		this.controllerEmpresa = controllerEmpresa;
	}

	public ControllerItemEmpresa getControllerItemEmpresa() {
		return controllerItemEmpresa;
	}

	public void setControllerItemEmpresa(ControllerItemEmpresa controllerItemEmpresa) {
		this.controllerItemEmpresa = controllerItemEmpresa;
	}

}
