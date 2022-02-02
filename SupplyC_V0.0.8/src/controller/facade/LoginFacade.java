package controller.facade;

import java.util.List;

import controller.controller.ControllerEmpresa;
import controller.controller.ControllerLogin;
import controller.singleton.UsuarioLogado;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Usuario;

public class LoginFacade {

	private ControllerLogin controllerLogin = new ControllerLogin();
	private ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
	private Stage primaryStage = new Stage();

	public Boolean login(String login, String senha) {

		this.controllerLogin.consultar(new Usuario(login, senha));
		Object list = this.controllerLogin.getAll();
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) list;
		if (usuarios.size() == 1) {
			UsuarioLogado.setUsuario(usuarios.get(usuarios.size() - 1));
			UsuarioLogado.setEmpresa(controllerEmpresa.consultarPorIdEmpresa(UsuarioLogado.getUsuario().getEmpresa_idEmpresa()));
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/home.fxml"));
				Scene scene = new Scene(root);
				String txt = "Empresa";
				if (UsuarioLogado.getUsuario().getPapel().contains("admin")) {
					txt = "Admin";
				}
				primaryStage.setTitle("SupplyC: " + txt);
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

}
