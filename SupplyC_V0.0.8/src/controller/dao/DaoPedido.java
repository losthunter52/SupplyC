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
import model.Pedido;

public class DaoPedido implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> pedidos = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from Pedido";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				pedidos.add(new Pedido(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return pedidos;
	}

	@Override
	public int inserir(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "insert into Pedido (Empresa_idEmpresa, GrupoPedido_idGrupoPedido, data, status) values (?,?, ?, ?)";
		int id = -1;
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ((Pedido) model).getEmpresa_idEmpresa());
			ps.setInt(2, ((Pedido) model).getGrupoPedido_idGrupoPedido());
			ps.setDate(3, ((Pedido) model).getData());
			ps.setString(4, ((Pedido) model).getStatus());
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
		String sql = "update Pedido set Empresa_idEmpresa = ?,  GrupoPedido_idGrupoPedido = ?, data = ?, status = ? where idPedido = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Pedido) model).getEmpresa_idEmpresa());
			ps.setInt(2, ((Pedido) model).getGrupoPedido_idGrupoPedido());
			ps.setDate(3, ((Pedido) model).getData());
			ps.setString(4, ((Pedido) model).getStatus());
			ps.setInt(5, ((Pedido) model).getIdPedido());
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
		String sql = "delete from Pedido where idPedido = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Pedido) model).getIdPedido());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir:" + erro.getMessage());
			return false;
		}
	}

}
