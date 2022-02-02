package controller.controller;

import controller.dao.DaoUsuarioJoinEmpresa;
import model.UsuarioJoinEmpresa;

public class ControllerUsuarioJoinEmpresa extends AbstractController {

	public ControllerUsuarioJoinEmpresa() {
		this.dao = new DaoUsuarioJoinEmpresa();
		this.consultar(new UsuarioJoinEmpresa());
	}

}
