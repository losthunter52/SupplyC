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
import model.Empresa;

public class DaoEmpresa implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> empresas = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from empresa";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				empresas.add(new Empresa(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return empresas;
	}

	@Override
	public int inserir(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "insert into Empresa (descricao) values (?)";
		int id = -1;
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ((Empresa) model).getDescricao());
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
		String sql = "update Empresa set descricao = ? where idEmpresa = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setString(1, ((Empresa) model).getDescricao());
			ps.setInt(2, ((Empresa) model).getIdEmpresa());
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
		String sql = "delete from Empresa where idEmpresa = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Empresa) model).getIdEmpresa());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir:" + erro.getMessage());
			return false;
		}
	}

}
