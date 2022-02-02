package controller.controller;

import java.util.ArrayList;
import java.util.List;

import controller.dao.DaoInterface;

public abstract class AbstractController {

	protected List<Object> objectList = new ArrayList<>();
	protected DaoInterface dao;

	public List<Object> getAll() {
		return objectList;
	}

	public Object getPorIndice(int i) {
		return objectList.get(i);
	}

	public void consultar(Object controller) {
		this.objectList.clear();
		this.objectList = this.dao.consultar(controller);
	}

	public boolean alterar(Object controller) {
		boolean success = this.dao.alterar(controller);
		this.consultar(new Object());
		return success;
	}

	public int inserir(Object controller) {
		int id = this.dao.inserir(controller);
		this.consultar(new Object());
		return id;
	}

	public boolean excluir(Object controller) {
		boolean success = this.dao.excluir(controller);
		this.consultar(new Object());
		return success;
	}

}
