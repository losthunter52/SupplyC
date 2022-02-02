package controller.controller;

import controller.dao.DaoLogin;

public class ControllerLogin extends AbstractController {

	public ControllerLogin() {
		this.dao = new DaoLogin();
	}

}
