package controller.controller;

import controller.dao.DaoItemEmpresa;
import model.ItemEmpresa;

public class ControllerItemEmpresa extends AbstractController {

	public ControllerItemEmpresa() {
		this.dao = new DaoItemEmpresa();
		this.consultar(new ItemEmpresa());
	}

}
