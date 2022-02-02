package model;

import db.Database;

public class ConexaoMySql extends RecuperaConexao {

	public ConexaoMySql(Database banco, RecuperaConexao proximo) {
		super(banco, proximo);
	}

}