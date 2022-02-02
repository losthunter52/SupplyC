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
import model.Usuario;

public class DaoUsuario implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> usuarios = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from Usuario";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuarios.add(
						new Usuario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar:" + erro.getMessage());
		}
		return usuarios;
	}

	@Override
	public int inserir(Object model) {
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "insert into Usuario (Empresa_idEmpresa, papel, login, senha) values (?, ?, ?, md5(?))";
		int id = -1;
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ((Usuario) model).getEmpresa_idEmpresa());
			ps.setString(2, ((Usuario) model).getPapel());
			ps.setString(3, ((Usuario) model).getLogin());
			ps.setString(4, ((Usuario) model).getSenha());
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
		String sql = "update Usuario set Empresa_idEmpresa = ? , login = ? , senha = md5(?) where idUsuario = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Usuario) model).getEmpresa_idEmpresa());
			ps.setString(2, ((Usuario) model).getLogin());
			ps.setString(3, ((Usuario) model).getSenha());
			ps.setInt(4, ((Usuario) model).getIdUsuario());
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
		String sql = "delete from Usuario where idUsuario = ?";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ((Usuario) model).getIdUsuario());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir:" + erro.getMessage());
			return false;
		}
	}

}
