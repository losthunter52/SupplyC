package controller.controller;

import controller.dao.DaoUsuario;
import model.Usuario;

public class ControllerUsuario extends AbstractController {

	public ControllerUsuario() {
		this.dao = new DaoUsuario();
		this.consultar(new Usuario());
	}

}
