package controller.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.dao.DaoItemEmpresaJoinItem;
import db.ConnectionFactory;
import model.ItemEmpresaJoinItem;

public class ControllerItemEmpresaJoinItem extends AbstractController {

	public ControllerItemEmpresaJoinItem() {
		this.dao = new DaoItemEmpresaJoinItem();
		this.consultar(new ItemEmpresaJoinItem());
	}

	public void consultarWhere(Object controller, int i) {
		this.objectList.clear();
		this.objectList = consultarWhereId(controller, i);
	}

	public List<Object> consultarWhereId(Object model, int idEmpresa) {
		List<Object> itens = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = """
				select idTable1, Empresa_idEmpresa, Item_idItem, associado, GrupoPedido_idGrupoPedido, categoria, preco, descricao
				from mydb.ItemEmpresa inner join mydb.Item on ItemEmpresa.Item_idItem = Item.idItem where Empresa_idEmpresa = ?;
				""";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idEmpresa);
			rs = ps.executeQuery();
			while (rs.next()) {
				itens.add(new ItemEmpresaJoinItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4),
						rs.getInt(5), rs.getString(6), rs.getFloat(7), rs.getString(8)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return itens;
	}

}
