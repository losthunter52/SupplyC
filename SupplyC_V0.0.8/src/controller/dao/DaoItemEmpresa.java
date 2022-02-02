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
import model.ItemEmpresa;

public class DaoItemEmpresa implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> itens = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from ItemEmpresa";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				itens.add(new ItemEmpresa(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4)));
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
		String sql = "insert into ItemEmpresa (Empresa_idEmpresa, Item_idItem, associado) values (?,?,?)";
		int id = -1;
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ((ItemEmpresa) model).getEmpresa_idEmpresa());
			ps.setInt(2, ((ItemEmpresa) model).getItem_idItem());
			ps.setBoolean(3, ((ItemEmpresa) model).getAssociado());
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
		String sql = "update ItemEmpresa set Empresa_idEmpresa = ?, Item_idItem = ?, associado = ? where idTable1 = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((ItemEmpresa) model).getEmpresa_idEmpresa());
			ps.setInt(2, ((ItemEmpresa) model).getItem_idItem());
			ps.setBoolean(3, ((ItemEmpresa) model).getAssociado());
			ps.setInt(4, ((ItemEmpresa) model).getIdItemEmpresa());
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
		String sql = "delete from ItemEmpresa where idItemEmpresa = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((ItemEmpresa) model).getIdItemEmpresa());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir:" + erro.getMessage());
			return false;
		}
	}

}
