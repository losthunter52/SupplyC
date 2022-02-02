package controller.singleton;

import model.Empresa;
import model.Usuario;

public class UsuarioLogado {

	private static Usuario usuario = null;
	private static Empresa empresa = null;

	public static Usuario getUsuario() {
		return usuario;
	}

	public static Empresa getEmpresa() {
		return empresa;
	}
	
	public static void setEmpresa(Empresa empresa) {
		UsuarioLogado.empresa = empresa;
	}
	
	public static void setUsuario(Usuario usuario) {
		UsuarioLogado.usuario = usuario;
	}

	public static void setUsuarioNull() {
		UsuarioLogado.usuario = null;
	}
}
