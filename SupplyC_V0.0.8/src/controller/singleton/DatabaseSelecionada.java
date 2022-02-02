package controller.singleton;

import db.Database;

public class DatabaseSelecionada {

	private static Database database;

	public static void setDatabase(Database database) {
		DatabaseSelecionada.database = database;
	}
	
	public static String getUrl() {
		return database.getUrl();
	}
	
	public static String getUsername() {
		return database.getUsername();
	}
	
	public static String getPassword() {
		return database.getPassword();
	}
	
}
