package controller.controller;

import controller.dao.DaoItem;
import model.Item;

public class ControllerItem extends AbstractController {

	public ControllerItem() {
		this.dao = new DaoItem();
		this.consultar(new Item());
	}

}
