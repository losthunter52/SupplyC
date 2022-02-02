package controller.controller;

import controller.dao.DaoItemPedidoJoinItem;
import model.ItemPedidoJoinItem;

public class ControllerItemPedidoJoinItem extends AbstractController {

	public ControllerItemPedidoJoinItem() {
		this.dao = new DaoItemPedidoJoinItem();
		this.consultar(new ItemPedidoJoinItem());
	}

}
