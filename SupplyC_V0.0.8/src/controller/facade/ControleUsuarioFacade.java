package controller.facade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.controller.ControllerEmpresa;
import controller.controller.ControllerUsuario;
import controller.controller.ControllerUsuarioJoinEmpresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Empresa;
import model.Usuario;
import model.UsuarioJoinEmpresa;

public class ControleUsuarioFacade {

	private ArrayList<UsuarioJoinEmpresa> listaUsuarios = new ArrayList<>();
	private UsuarioJoinEmpresa usuarioJoinEmpresa;
	private Usuario usuario = new Usuario();
	private Empresa empresa = new Empresa();
	private ControllerUsuarioJoinEmpresa controllerUsuarioJoinEmpresa = new ControllerUsuarioJoinEmpresa();
	private ControllerUsuario controllerUsuario = new ControllerUsuario();
	private ControllerEmpresa controllerEmpresa = new ControllerEmpresa();
	private ObservableList<UsuarioJoinEmpresa> data = FXCollections.observableArrayList();

	public ControleUsuarioFacade() {
		super();
	}

	public void salvar(Boolean isAdmin, String descricao, String papel, String login, String senha) {

		try {
			if (isAdmin) {
				empresa.setDescricao(descricao);
				usuario.setEmpresa_idEmpresa(1);
				usuario.setPapel(papel);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				controllerUsuario.inserir(usuario);
			} else {
				empresa.setDescricao(descricao);
				int i = controllerEmpresa.inserir(empresa);
				usuario.setEmpresa_idEmpresa(i);
				usuario.setPapel(papel);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				controllerUsuario.inserir(usuario);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}

	}

	public void alterar(Boolean isAdmin, int i, String descricao, String papel, String login, String senha) {
		try {
			if (isAdmin) {
				usuarioJoinEmpresa = (UsuarioJoinEmpresa) controllerUsuarioJoinEmpresa.getPorIndice(i);
				empresa.setIdEmpresa(1);
				empresa.setDescricao(descricao);
				usuario.setIdUsuario(usuarioJoinEmpresa.getIdUsuario());
				usuario.setEmpresa_idEmpresa(1);
				usuario.setPapel(papel);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				controllerEmpresa.alterar(empresa);
				controllerUsuario.alterar(usuario);
			} else {
				usuarioJoinEmpresa = (UsuarioJoinEmpresa) controllerUsuarioJoinEmpresa.getPorIndice(i);
				empresa.setIdEmpresa(usuarioJoinEmpresa.getEmpresa_idEmpresa());
				empresa.setDescricao(descricao);
				usuario.setIdUsuario(usuarioJoinEmpresa.getIdUsuario());
				usuario.setEmpresa_idEmpresa(usuarioJoinEmpresa.getEmpresa_idEmpresa());
				usuario.setPapel(papel);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				controllerEmpresa.alterar(empresa);
				controllerUsuario.alterar(usuario);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	public void excluir(Boolean isAdmin, int i, String descricao, String papel, String login, String senha) {
		try {
			if (isAdmin) {
				usuarioJoinEmpresa = (UsuarioJoinEmpresa) controllerUsuarioJoinEmpresa.getPorIndice(i);
				usuario.setIdUsuario(usuarioJoinEmpresa.getIdUsuario());
				usuario.setEmpresa_idEmpresa(usuarioJoinEmpresa.getEmpresa_idEmpresa());
				usuario.setPapel(papel);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				controllerUsuario.excluir(usuario);
			} else {
				usuarioJoinEmpresa = (UsuarioJoinEmpresa) controllerUsuarioJoinEmpresa.getPorIndice(i);
				empresa.setIdEmpresa(usuarioJoinEmpresa.getEmpresa_idEmpresa());
				empresa.setDescricao(descricao);
				usuario.setIdUsuario(usuarioJoinEmpresa.getIdUsuario());
				usuario.setEmpresa_idEmpresa(usuarioJoinEmpresa.getEmpresa_idEmpresa());
				usuario.setPapel(papel);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				controllerUsuario.excluir(usuario);
				controllerEmpresa.excluir(empresa);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void consultar() {
		this.controllerUsuarioJoinEmpresa = new ControllerUsuarioJoinEmpresa();
		List<UsuarioJoinEmpresa> lista = (List<UsuarioJoinEmpresa>) (List<?>) this.controllerUsuarioJoinEmpresa
				.getAll();
		if (!listaUsuarios.isEmpty()) {
			listaUsuarios.clear();
		}
		listaUsuarios = (ArrayList<UsuarioJoinEmpresa>) lista;
	}

	public ObservableList<UsuarioJoinEmpresa> atualizarLista() {
		consultar();
		data.clear();
		for (UsuarioJoinEmpresa element : listaUsuarios) {
			data.add(new UsuarioJoinEmpresa(element.getIdUsuario(),
					element.getEmpresa_idEmpresa(), element.getPapel(),
					element.getLogin(), element.getSenha(),
					element.getDescricao()));
		}
		return data;
	}

	public UsuarioJoinEmpresa selecionarIndice(int indice) {
		try {
			usuarioJoinEmpresa = (UsuarioJoinEmpresa) controllerUsuarioJoinEmpresa.getPorIndice(indice);
			consultar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
		return usuarioJoinEmpresa;
	}

	public UsuarioJoinEmpresa getUsuarioJoinEmpresa() {
		return usuarioJoinEmpresa;
	}

	public void setUsuarioJoinEmpresa(UsuarioJoinEmpresa usuarioJoinEmpresa) {
		this.usuarioJoinEmpresa = usuarioJoinEmpresa;
	}

	public ArrayList<UsuarioJoinEmpresa> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<UsuarioJoinEmpresa> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public ControllerUsuarioJoinEmpresa getControllerUsuarioJoinEmpresa() {
		return controllerUsuarioJoinEmpresa;
	}

	public void setControllerUsuarioJoinEmpresa(ControllerUsuarioJoinEmpresa controllerUsuarioJoinEmpresa) {
		this.controllerUsuarioJoinEmpresa = controllerUsuarioJoinEmpresa;
	}

	public ControllerUsuario getControllerUsuario() {
		return controllerUsuario;
	}

	public void setControllerUsuario(ControllerUsuario controllerUsuario) {
		this.controllerUsuario = controllerUsuario;
	}

	public ControllerEmpresa getControllerEmpresa() {
		return controllerEmpresa;
	}

	public void setControllerEmpresa(ControllerEmpresa controllerEmpresa) {
		this.controllerEmpresa = controllerEmpresa;
	}

}
