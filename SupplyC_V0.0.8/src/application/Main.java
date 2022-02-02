package application;

import controller.singleton.DatabaseSelecionada;
import db.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ConexaoMySql;
import model.RecuperaConexao;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Database banco1 = new Database().url("jdbc:mysql://localhost:3306/mydb").username("").password("");
		Database banco2 = new Database().url("jdbc:mysql://localhost:3306/mydb").username("root").password("");
		Database banco3 = new Database().url("jdbc:mysql://localhost:3306/mydb").username("root").password("root");
		RecuperaConexao teste = new ConexaoMySql(banco1, new ConexaoMySql(banco2, new ConexaoMySql(banco3, new ConexaoMySql(null, null))));
		
		DatabaseSelecionada.setDatabase(teste.recuperar());
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("SupplyC");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
