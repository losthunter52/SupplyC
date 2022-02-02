package model;

public class Empresa {
	private int idEmpresa;
	private String descricao;
	private AbstractAviso aviso;

	public Empresa() {
		super();
	}

	public Empresa(int idEmpresa) {
		super();
		this.idEmpresa = idEmpresa;
	}

	public Empresa(int i, String string, String string2) {
		super();
		this.idEmpresa = i;
		this.descricao = string;
		if (string2 == null) {
			this.aviso = new AvisoVazio(string2);
		} else {
			this.aviso = new AvisoComum(string2);
		}

	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAviso() {
		if(aviso.getAviso() != null && aviso.getAviso().length() > 590){            
            String aux = aviso.getAviso().substring(0, 591) + "...";
            String[] removerSemAvisos = aux.split("--- Sem avisos ---");
            return removerSemAvisos[0];
        } else {
        	String aux = aviso.getAviso();
            String[] removerSemAvisos = aux.split("--- Sem avisos ---");
            return removerSemAvisos[0];
        } 
	}

	public void setAviso(String aviso) {
		this.aviso = new AvisoComposto(aviso, this.aviso);
	}

}
