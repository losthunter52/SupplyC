package controller.dao;

import java.util.List;

public interface DaoInterface {

	public List<Object> consultar(Object model);

	public int inserir(Object model);

	public boolean alterar(Object model);

	public boolean excluir(Object model);

}
