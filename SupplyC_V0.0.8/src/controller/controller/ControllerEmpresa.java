package controller.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.dao.DaoEmpresa;
import db.ConnectionFactory;
import model.Empresa;

public class ControllerEmpresa extends AbstractController {

	public ControllerEmpresa() {
		this.dao = new DaoEmpresa();
		this.consultar(new Empresa());
	}

	public boolean alterarAviso(Object controller) {
		boolean success = this.daoAlterarAviso(controller);
		this.consultar(new Object());
		return success;
	}

	public boolean daoAlterarAviso(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "update Empresa set aviso = ? where idEmpresa = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setString(1, ((Empresa) model).getAviso());
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
	
	public Empresa consultarPorIdEmpresa(int idEmpresa) {
		Empresa empresa = null;
		empresa = consultarPorId(idEmpresa);
		return empresa;
	}
	
	public Empresa consultarPorId(int id) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from empresa where idEmpresa = ?";
		Empresa empresa = null;
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				empresa = new Empresa(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar:" + erro.getMessage());
		}
		return empresa;
	}
}
