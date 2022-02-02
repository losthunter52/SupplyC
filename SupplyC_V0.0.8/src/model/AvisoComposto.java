package model;

public class AvisoComposto extends AbstractAviso{

	AbstractAviso abstractAviso;
	
	public AvisoComposto(String aviso, AbstractAviso abstractAviso) {
		super(aviso);
		this.abstractAviso = abstractAviso;
	}
	
	public String getAviso() {
		return this.aviso + "\n" + abstractAviso.getAviso();
	}
	
}
