package model;

import java.sql.Connection;

import javax.swing.JOptionPane;

import db.ConnectionFactory;
import db.Database;

public abstract class RecuperaConexao {

	private Database banco;
	private RecuperaConexao proximo;

	public RecuperaConexao(Database banco, RecuperaConexao proximo) {
		this.banco = banco;
		this.proximo = proximo;
	}

	public Database recuperar() {
		Connection a = ConnectionFactory.connectionChain(banco.getUrl(), banco.getUsername(), banco.getPassword());
		if (a == null) {
			return chamarProximo();
		}
		else
			return banco;
	}

	private Database chamarProximo() {
		if (proximo == null) {
			JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao banco de dados");
		}
		return proximo.recuperar();
	}

	
}
