package ifpr.pgua.eic.biblioteca.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import ifpr.pgua.eic.biblioteca.App;
import ifpr.pgua.eic.biblioteca.models.Autor;
import ifpr.pgua.eic.biblioteca.models.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroLivro implements Initializable {
    private Biblioteca gerenciador;

    @FXML
    private TextField tfAno;

    @FXML
    private TextField tfEditora;

    @FXML
    private TextField tfTitulo;

    @FXML
    private ComboBox<Autor> cbAutor;

    public TelaCadastroLivro(Biblioteca gerenciador) {
        this.gerenciador = gerenciador;
    }

    @FXML
    void cadastrarLivro(ActionEvent event) {
        if (!validaEntrada()) {
            mostraErro("Certifique-se que não há nenhum campo vazio.");
            return;
        }

        try {
            Integer.valueOf(tfAno.getText());
        } catch (NumberFormatException e) {
            mostraErro("Ano inválido.");
            return;
        }

        String titulo = tfTitulo.getText();
        String editora = tfEditora.getText();
        int ano = Integer.valueOf(tfAno.getText());

        Autor autor = cbAutor.getSelectionModel().getSelectedItem();

        boolean cadastroSucesso = gerenciador.cadastrarLivro(titulo, editora, ano, autor);
        if (!cadastroSucesso) {
            mostraErro("Livro ja cadastrado.");
            return;
        }

        limpaEntrada();
    }

    private boolean validaEntrada() {
        boolean sucesso = true;
        String vazio = "";

        if (tfTitulo.getText().equals(vazio)) {
            sucesso = false;
        }
        if (tfEditora.getText().equals(vazio)) {
            sucesso = false;
        }
        if (tfAno.getText().equals(vazio)) {
            sucesso = false;
        }
        if (cbAutor.getSelectionModel().getSelectedItem() == null) {
            sucesso = false;
        }
        return sucesso;
    }

    private void mostraErro(String mensagem) {
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Erro ao cadastrar");
            a.setContentText(mensagem);
            a.showAndWait();
    }

    private void limpaEntrada() {
        tfTitulo.clear();
        tfEditora.clear();
        tfAno.clear();
        cbAutor.getSelectionModel().clearSelection();
    }

    @FXML
    void cadastrarAutor(ActionEvent e) {
        App.popScreen();
        App.pushScreen("CADASTRO_AUTOR");
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbAutor.getItems().addAll(gerenciador.getAutores());
    }
}
