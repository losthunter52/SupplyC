package model;

public class AvisoVazio extends AbstractAviso{
	
	public AvisoVazio(String string2) {
		super(string2);
	}

	public String getAviso() {
		return " --- Sem avisos --- ";
	}
	
}
