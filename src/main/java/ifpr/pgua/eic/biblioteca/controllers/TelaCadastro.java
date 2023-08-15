package ifpr.pgua.eic.biblioteca.controllers;

import ifpr.pgua.eic.biblioteca.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaCadastro {

    @FXML
    void voltar(ActionEvent e) {
        App.popScreen();
    }

    @FXML
    void cadastrarAutor(ActionEvent e) {
        App.popScreen();
        App.pushScreen("CADASTRO_AUTOR");
    }

    @FXML
    void cadastrarLivro(ActionEvent e) {
        App.popScreen();
        App.pushScreen("CADASTRO_LIVRO");
    }


}
