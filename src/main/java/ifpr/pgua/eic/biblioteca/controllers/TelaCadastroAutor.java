package ifpr.pgua.eic.biblioteca.controllers;

import ifpr.pgua.eic.biblioteca.App;
import ifpr.pgua.eic.biblioteca.models.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroAutor {

    private Biblioteca gerenciador;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    public TelaCadastroAutor(Biblioteca gerenciador) {
        this.gerenciador = gerenciador;
    }

    @FXML
    void cadastrarAutor(ActionEvent e) {
        String nome = tfNome.getText();
        String email = tfEmail.getText();

        if (nome.equals("") || email.equals("")) {
            mostraErro("Certifique-se que não há nenhum campo vazio.");
            return;
        }

        int cadastroStatus = gerenciador.cadastrarAutor(nome, email);

        if (cadastroStatus == 1) {
            mostraErro("Autor já cadastrado.");
            return;
        }
        if (cadastroStatus == 2) {
            mostraErro("Email já cadastrado.");
            return;

        }

        tfNome.clear();
        tfEmail.clear();
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @FXML
    void cadastrarLivro(ActionEvent e) {
        App.popScreen();
        App.pushScreen("CADASTRO_LIVRO");
    }

    private void mostraErro(String mensagem) {
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Erro ao cadastrar");
            a.setContentText(mensagem);
            a.showAndWait();
    }
}
