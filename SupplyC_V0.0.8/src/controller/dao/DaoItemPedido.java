package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.ConnectionFactory;
import model.ItemPedido;

public class DaoItemPedido implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> itensPedidos = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from ItemPedido";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				itensPedidos.add(new ItemPedido(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return itensPedidos;
	}

	@Override
	public int inserir(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "insert into ItemPedido (Item_idItem, Pedido_idPedido, quantidade) values (?,?,?)";
		int id = -1;
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ((ItemPedido) model).getItem_idItem());
			ps.setInt(2, ((ItemPedido) model).getPedido_idPedido());
			ps.setFloat(3, ((ItemPedido) model).getQuantidade());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir:" + erro.getMessage());
		}
		return id;
	}

	@Override
	public boolean alterar(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "update ItemPedido set Item_idItem = ?, Pedido_idPedido = ?, quantidade = ? where idItemPedido = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((ItemPedido) model).getItem_idItem());
			ps.setInt(2, ((ItemPedido) model).getPedido_idPedido());
			ps.setFloat(3, ((ItemPedido) model).getQuantidade());
			ps.setInt(4, ((ItemPedido) model).getIdItemPedido());
			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar:" + erro.getMessage());
			return false;
		}
	}

	@Override
	public boolean excluir(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "delete from ItemPedido where idItemPedido = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((ItemPedido) model).getIdItemPedido());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir:" + erro.getMessage());
			return false;
		}
	}

}
