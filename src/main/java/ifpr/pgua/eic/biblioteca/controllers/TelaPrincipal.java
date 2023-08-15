package ifpr.pgua.eic.biblioteca.controllers;

import ifpr.pgua.eic.biblioteca.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipal {

    @FXML
    void abrirTelaCadastro(ActionEvent event) {
        App.pushScreen("CADASTRO");
    }

    @FXML
    void abrirTelaVisualizarAutores(ActionEvent event) {
        App.pushScreen("VISUALIZAR_AUTORES");
    }

    @FXML
    void abrirTelaEmprestimo(ActionEvent e) {
        App.pushScreen("EMPRESTIMO");
    }
}
