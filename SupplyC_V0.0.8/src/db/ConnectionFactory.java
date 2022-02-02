package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.singleton.DatabaseSelecionada;

/**
 *
 * @author 55479
 */
public class ConnectionFactory {
	/**
	 *
	 * @return
	 * "jdbc:mysql://localhost:3306/mydb"
	 */
	
	public static Connection connectionChain(String url, String username, String password) {
		java.sql.Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException erro) {
		}
		return connection;
	}
	
	public static Connection connectionBD() {
		java.sql.Connection connection = null;
		try {
			String url = DatabaseSelecionada.getUrl();
			String username = DatabaseSelecionada.getUsername();
			String password = DatabaseSelecionada.getPassword();
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ConectionFactory Error:" + erro.getMessage());
		}
		return connection;
	}
	
	
}