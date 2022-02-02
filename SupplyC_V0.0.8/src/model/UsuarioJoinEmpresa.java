package model;

public class UsuarioJoinEmpresa {

	private int idUsuario;
	private int empresa_idEmpresa;
	private String papel;
	private String login;
	private String senha;
	private String descricao;

	public UsuarioJoinEmpresa() {
		super();
	}

	public UsuarioJoinEmpresa(int idUsuario, int empresa_idEmpresa, String papel, String login, String senha,
			String descricao) {
		super();
		this.idUsuario = idUsuario;
		this.empresa_idEmpresa = empresa_idEmpresa;
		this.papel = papel;
		this.login = login;
		this.senha = senha;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
