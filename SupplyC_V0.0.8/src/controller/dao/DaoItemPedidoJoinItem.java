package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.ConnectionFactory;
import model.ItemPedidoJoinItem;

public class DaoItemPedidoJoinItem implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> itens = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = """
				select idItemPedido, Item_idItem, Pedido_idPedido, quantidade, GrupoPedido_idGrupoPedido, categoria, preco, descricao
				from mydb.ItemPedido inner join mydb.Item on ItemPedido.Item_idItem = Item.idItem;
				""";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				itens.add(new ItemPedidoJoinItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5),
						rs.getString(6), rs.getFloat(7), rs.getString(8)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return itens;
	}

	public List<Object> consultarWhere(Object model, int idPedido) {
		List<Object> itens = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = """
				select idItemPedido, Item_idItem, Pedido_idPedido, quantidade, GrupoPedido_idGrupoPedido, categoria, preco, descricao
				from mydb.ItemPedido inner join mydb.Item on ItemPedido.Item_idItem = Item.idItem where idPedido = ?;
				""";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idPedido);
			rs = ps.executeQuery();
			while (rs.next()) {
				itens.add(new ItemPedidoJoinItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5),
						rs.getString(6), rs.getFloat(7), rs.getString(8)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return itens;
	}

	@Override
	public int inserir(Object model) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean alterar(Object model) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean excluir(Object model) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
