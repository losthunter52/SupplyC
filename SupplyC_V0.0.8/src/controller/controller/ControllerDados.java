package controller.controller;

import controller.dao.DaoDados;

public class ControllerDados extends AbstractController {

	public ControllerDados() {
		this.dao = new DaoDados();
		this.consultar(new Object());
	}

}
