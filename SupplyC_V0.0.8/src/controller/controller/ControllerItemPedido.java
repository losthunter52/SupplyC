package controller.controller;

import controller.dao.DaoItemPedido;
import model.ItemPedido;

public class ControllerItemPedido extends AbstractController {

	public ControllerItemPedido() {
		this.dao = new DaoItemPedido();
		this.consultar(new ItemPedido());
	}

}
