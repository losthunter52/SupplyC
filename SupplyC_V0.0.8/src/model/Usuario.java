package model;

public class Usuario {

	private int idUsuario;
	private int empresa_idEmpresa;
	private String papel;
	private String login;
	private String senha;

	public Usuario() {
		super();
		this.idUsuario = 0;
		this.empresa_idEmpresa = 0;
		this.papel = "";
		this.login = "";
		this.senha = "";
	}

	public Usuario(int idUsuario, int empresa_idEmpresa, String papel, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.empresa_idEmpresa = empresa_idEmpresa;
		this.papel = papel;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String login, String senha) {
		super();
		this.idUsuario = 0;
		this.empresa_idEmpresa = 0;
		this.papel = "deslogado";
		this.login = login;
		this.senha = senha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getEmpresa_idEmpresa() {
		return empresa_idEmpresa;
	}

	public void setEmpresa_idEmpresa(int empresa_idEmpresa) {
		this.empresa_idEmpresa = empresa_idEmpresa;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
