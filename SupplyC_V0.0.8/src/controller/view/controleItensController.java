package controller.view;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import controller.facade.ControleItemFacade;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Item;

@SuppressWarnings("rawtypes")
public class controleItensController implements Initializable {
	@FXML
	private TextField txtDescricao;
	@FXML
	private TableView tableItens;
	@FXML
	private TableColumn columnCategoria;
	@FXML
	private TableColumn columnDescricao;
	@FXML
	private TableColumn columnPreco;
	@FXML
	private TableColumn columnGrupoPedido;
	@FXML
	private ComboBox boxCategoria;
	@FXML
	private ComboBox boxGrupoPedido;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnExcluir;
	@FXML
	private TextField txtPreco;

	private Boolean alterar = false;
	private String categoria = "Expediente";
	private int idGrupoPedido = 1;
	private ControleItemFacade controleItens = new ControleItemFacade();
	private float preco = -1;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		boxCategoria.getItems().addAll("Despesa", "Expediente", "Materia Prima");
		boxGrupoPedido.getItems().addAll("Quinzenal", "Semanal", "Mensal");
		clear();
		tableItens.setItems(atualizarTabela());
		columnCategoria.setCellValueFactory(new PropertyValueFactory<Item, String>("categoria"));
		columnDescricao.setCellValueFactory(new PropertyValueFactory<Item, String>("descricao"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<Item, String>("preco"));
		columnGrupoPedido.setCellValueFactory(new PropertyValueFactory<Item, Integer>("grupoPedido_idGrupoPedido"));
	}

	@SuppressWarnings("unchecked")
	private void clear() {
		boxCategoria.setValue("Expediente");
		categoria = "Expediente";
		boxGrupoPedido.setValue("Quinzenal");
		idGrupoPedido = 1;
		txtPreco.setDisable(true);
		txtDescricao.setText("");
		txtPreco.setText("");
		alterar = false;
		preco = -1;
		txtDescricao.requestFocus();
	}

	public ObservableList<Item> atualizarTabela() {
		clear();
		return controleItens.atualizarLista();
	}

	// Event Listener on TextField[#txtDescricao].onKeyPressed
	@FXML
	public void txtDescricaoKeyPressed(KeyEvent event) {
		// TODO Autogenerated
		if (event.getCode() == KeyCode.ENTER) {
			if (!txtDescricao.getText().isEmpty()) {
				txtPreco.setDisable(false);
				txtPreco.requestFocus();
			}
		}
	}

	// Event Listener on TableView[#tableItens].onKeyPressed
	@SuppressWarnings("unchecked")
	@FXML
	public void tableItensKeyPressed(KeyEvent event) {
		// TODO Autogenerated
		if (event.getCode() == KeyCode.ENTER) {
			Item item = controleItens.selecionarIndice(tableItens.getSelectionModel().getSelectedIndex());
			txtDescricao.setText(item.getDescricao());
			txtPreco.setDisable(false);
			txtPreco.setText("" + item.getPreco());
			boxCategoria.setValue(item.getCategoria());
			categoria = item.getCategoria();
			boxGrupoPedido.setValue(grupoPedido(item.getGrupoPedido_idGrupoPedido()));
			idGrupoPedido = item.getGrupoPedido_idGrupoPedido();
			alterar = true;
		}
	}

	public String grupoPedido(int i) {
		if (i == 1) {
			return "Quinzenal";
		}
		if (i == 2) {
			return "Semanal";
		}
		if (i == 3) {
			return "Mensal";
		}
		return "";
	}

	// Event Listener on TableView[#tableItens].onMouseClicked
	@SuppressWarnings("unchecked")
	@FXML
	public void tableItensMouseClicked(MouseEvent event) {
		// TODO Autogenerated
		if (tableItens.getSelectionModel().getSelectedIndex() >= 0) {
			Item item = controleItens.selecionarIndice(tableItens.getSelectionModel().getSelectedIndex());
			txtDescricao.setText(item.getDescricao());
			txtPreco.setDisable(false);
			txtPreco.setText("" + item.getPreco());
			boxCategoria.setValue(item.getCategoria());
			categoria = item.getCategoria();
			boxGrupoPedido.setValue(grupoPedido(item.getGrupoPedido_idGrupoPedido()));
			idGrupoPedido = item.getGrupoPedido_idGrupoPedido();
			alterar = true;
		}
	}

	// Event Listener on ComboBox[#boxCategoria].onAction
	@FXML
	public void boxCategoriaClicked(ActionEvent event) {
		// TODO Autogenerated
		if (boxCategoria.getValue().equals("Despesa")) {
			categoria = "Despesa";
		}
		if (boxCategoria.getValue().equals("Expediente")) {
			categoria = "Expediente";
		}
		if (boxCategoria.getValue().equals("Materia Prima")) {
			categoria = "Materia Prima";
		}

	}

	// Event Listener on ComboBox[#bocGrupoPedido].onAction
	@FXML
	public void boxGrupoPedidoClicked(ActionEvent event) {
		// TODO Autogenerated
		if (boxGrupoPedido.getValue().equals("Quinzenal")) {
			idGrupoPedido = 1;
		}
		if (boxGrupoPedido.getValue().equals("Semanal")) {
			idGrupoPedido = 2;
		}
		if (boxGrupoPedido.getValue().equals("Mensal")) {
			idGrupoPedido = 3;
		}
	}

	// Event Listener on Button[#btnSalvar].onAction
	@FXML
	public void btnSalvarClicked(ActionEvent event) {
		// TODO Autogenerated
		if (txtDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo Descricao nao pode ser vazio");
			txtDescricao.requestFocus();
		} else {
			if (txtPreco.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"O campo Preco nao pode ser vazio, Escreva" + "algo em Descricao e tecle Enter");
				txtDescricao.requestFocus();
			} else {
				if (preco == -1) {
					JOptionPane.showMessageDialog(null,
							"O campo Preco nao foi confirmado, Escreva" + "algo em Preco e tecle Enter");
					txtPreco.requestFocus();
				} else {
					if (alterar) {
						controleItens.alterar(tableItens.getSelectionModel().getSelectedIndex(), idGrupoPedido,
								categoria, preco, txtDescricao.getText());
						atualizarTabela();
						alterar = false;
					} else {
						if (!alterar) {
							controleItens.salvar(idGrupoPedido, categoria, preco, txtDescricao.getText());
							atualizarTabela();
						}
					}
				}
			}
		}
	}

	// Event Listener on Button[#btnSalvar].onKeyPressed
	@FXML
	public void btnSalvarKeyPressed(KeyEvent event) {
		// TODO Autogenerated
		if (event.getCode() == KeyCode.ENTER) {
			if (txtDescricao.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo Descricao nao pode ser vazio");
				txtDescricao.requestFocus();
			} else {
				if (txtPreco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"O campo Preco nao pode ser vazio, Escreva" + "algo em Descricao e tecle Enter");
					txtDescricao.requestFocus();
				} else {
					if (preco == -1) {
						JOptionPane.showMessageDialog(null,
								"O campo Preco nao foi confirmado, Escreva" + "algo em Preco e tecle Enter");
						txtPreco.requestFocus();
					} else {
						if (alterar) {
							controleItens.alterar(tableItens.getSelectionModel().getSelectedIndex(), idGrupoPedido,
									categoria, preco, txtDescricao.getText());
							atualizarTabela();
							alterar = false;
						} else {
							if (!alterar) {
								controleItens.salvar(idGrupoPedido, categoria, preco, txtDescricao.getText());
								atualizarTabela();
							}
						}
					}
				}
			}
		}
	}

	// Event Listener on Button[#btnExcluir].onAction
	@FXML
	public void btnExcluirClicked(ActionEvent event) {
		// TODO Autogenerated
		if (tableItens.getSelectionModel().getSelectedIndex() >= 0) {
			if (alterar) {
				controleItens.excluir(tableItens.getSelectionModel().getSelectedIndex(), idGrupoPedido, categoria,
						preco, txtDescricao.getText());
				atualizarTabela();
				alterar = false;
			}
		}
	}

	// Event Listener on TextField[#txtPreco].onKeyPressed
	@FXML
	public void txtPrecoKeyPressed(KeyEvent event) {
		// TODO Autogenerated
		if (event.getCode() == KeyCode.ENTER) {
			try {
				preco = Float.parseFloat(txtPreco.getText());
				btnSalvar.requestFocus();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "O valor informado em Preco deve ser um valor numerico");
			}
		}
	}
}
