package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.ConnectionFactory;
import model.Usuario;

public class DaoLogin implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> usuarios = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = "select * from usuario where login = ? and senha = md5(?)";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			ps.setString(1, ((Usuario) model).getLogin());
			ps.setString(2, ((Usuario) model).getSenha());
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
