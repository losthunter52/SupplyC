package controller.controller;

import controller.dao.DaoGrupoPedido;
import model.GrupoPedido;

public class ControllerGrupoPedido extends AbstractController {

	public ControllerGrupoPedido() {
		this.dao = new DaoGrupoPedido();
		this.consultar(new GrupoPedido());
	}

}
