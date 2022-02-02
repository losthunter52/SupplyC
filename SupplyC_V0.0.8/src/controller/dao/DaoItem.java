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
import model.Item;

public class DaoItem implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> itens = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from Item";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				itens.add(new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
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
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "insert into Item (GrupoPedido_idGrupoPedido, categoria, preco, descricao) values (?,?,?,?)";
		int id = -1;
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ((Item) model).getGrupoPedido_idGrupoPedido());
			ps.setString(2, ((Item) model).getCategoria());
			ps.setFloat(3, ((Item) model).getPreco());
			ps.setString(4, ((Item) model).getDescricao());
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
		String sql = "update Item set GrupoPedido_idGrupoPedido = ?, categoria = ?, preco = ?, descricao = ? where idItem = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Item) model).getGrupoPedido_idGrupoPedido());
			ps.setString(2, ((Item) model).getCategoria());
			ps.setFloat(3, ((Item) model).getPreco());
			ps.setString(4, ((Item) model).getDescricao());
			ps.setInt(5, ((Item) model).getIdItem());
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
		String sql = "delete from Item where idItem = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Item) model).getIdItem());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir:" + erro.getMessage());
			return false;
		}
	}

}
