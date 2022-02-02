package controller.controller;

import controller.dao.DaoPedido;
import model.Pedido;

public class ControllerPedido extends AbstractController {

	public ControllerPedido() {
		this.dao = new DaoPedido();
		this.consultar(new Pedido());
	}

}
