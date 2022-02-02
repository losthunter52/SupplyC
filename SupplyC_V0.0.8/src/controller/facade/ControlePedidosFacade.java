package controller.facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.controller.ControllerEmpresa;
import controller.controller.ControllerPedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Empresa;
import model.Pedido;

public class ControlePedidosFacade {

	private Pedido pedido = new Pedido();
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private ObservableList<Pedido> data = FXCollections.observableArrayList();
	private ControllerPedido controllerPedido = new ControllerPedido();
	private ControllerEmpresa controllerEmpresa = new ControllerEmpresa();

	public void salvar(int idGrupoPedido, Date data, String status) {
		consultarEmpresa();
		int a = empresas.size();
		try {
			for (int i = 1; i < a; i++) {
				consultarEmpresa();
				pedido.setIdPedido(0);
				pedido.setGrupoPedido_idGrupoPedido(idGrupoPedido);
				pedido.setEmpresa_idEmpresa(empresas.get(i).getIdEmpresa());
				pedido.setData(data);
				pedido.setStatus(status);
				int x = controllerPedido.inserir(pedido);
				empresas.get(i).setAviso("Adicionado: \n\n   Pedido: " + x + "\n   Data: " + data + "\n   Status: " + status + "\n\n");
				controllerEmpresa.alterarAviso(empresas.get(i));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}

	}
	
	public void salvarCriar(int idGrupoPedido, Date data) {
		consultarEmpresa();
		int a = empresas.size();
		try {
			for (int i = 1; i < a; i++) {
				consultarEmpresa();
				pedido.setIdPedido(0);
				pedido.setGrupoPedido_idGrupoPedido(idGrupoPedido);
				pedido.setEmpresa_idEmpresa(empresas.get(i).getIdEmpresa());
				pedido.setData(data);
				pedido.criar();
				int x = controllerPedido.inserir(pedido);
				empresas.get(i).setAviso("Adicionado: \n\n   Pedido: " + x + "\n   Data: " + data + "\n   Status: adicionado\n\n");
				controllerEmpresa.alterarAviso(empresas.get(i));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erroxx:" + e.getMessage());
		}

	}

	public void alterar(int indice, int idGrupoPedido, Date data, String status) {
		Pedido aux = selecionarIndice(indice);
		try {
			aux.setGrupoPedido_idGrupoPedido(idGrupoPedido);
			aux.setData(data);
			aux.setStatus(status);
			controllerPedido.alterar(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}
	
	public void alterarCriar(int indice, int idGrupoPedido, Date data) {
		Pedido aux = selecionarIndice(indice);
		try {
			aux.setGrupoPedido_idGrupoPedido(idGrupoPedido);
			aux.setData(data);
			aux.criar();
			controllerPedido.alterar(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	public void excluir(int idPedido, int idGrupoPedido, Date data) {
		Pedido aux = selecionarIndice(idPedido);
		try {
			aux.setGrupoPedido_idGrupoPedido(idGrupoPedido);
			aux.setData(data);
			aux.setStatus("excluido");
			controllerPedido.excluir(aux);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void consultarPedido() {
		this.controllerPedido = new ControllerPedido();
		List<Pedido> lista = (List<Pedido>) (List<?>) this.controllerPedido.getAll();
		if (!pedidos.isEmpty()) {
			pedidos.clear();
		}
		pedidos = (ArrayList<Pedido>) lista;
	}

	@SuppressWarnings("unchecked")
	public void consultarEmpresa() {
		this.controllerEmpresa = new ControllerEmpresa();
		List<Empresa> lista = (List<Empresa>) (List<?>) this.controllerEmpresa.getAll();
		if (!empresas.isEmpty()) {
			empresas.clear();
		}
		empresas = (ArrayList<Empresa>) lista;
	}

	public ObservableList<Pedido> atualizarLista() {
		consultarPedido();
		data.clear();
		for (Pedido element : pedidos) {
			data.add(new Pedido(element.getIdPedido(), element.getEmpresa_idEmpresa(),
					element.getGrupoPedido_idGrupoPedido(), element.getData(),
					element.getStatus()));
		}
		return data;
	}

	public Pedido selecionarIndice(int indice) {
		try {
			pedido = (Pedido) controllerPedido.getPorIndice(indice);
			consultarPedido();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
		return pedido;
	}

	public ControlePedidosFacade() {
		super();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
