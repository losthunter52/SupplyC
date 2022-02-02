package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.ConnectionFactory;
import model.UsuarioJoinEmpresa;

public class DaoUsuarioJoinEmpresa implements DaoInterface {

	@Override
	public List<Object> consultar(Object model) {
		List<Object> usuarios = new ArrayList<>();
		Connection connection = ConnectionFactory.connectionBD();
		String sql = """
				select idUsuario, Empresa_idEmpresa, papel, login, senha, descricao
				from Usuario inner join Empresa on Usuario.Empresa_idEmpresa = Empresa.idEmpresa;
				""";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuarios.add(new UsuarioJoinEmpresa(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
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
