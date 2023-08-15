package ifpr.pgua.eic.biblioteca.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.biblioteca.App;
import ifpr.pgua.eic.biblioteca.models.Biblioteca;
import ifpr.pgua.eic.biblioteca.models.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class TelaVisualizarLivros implements Initializable{

    private Biblioteca gerenciador;

    @FXML
    private ListView<Livro> lstLivros;
    @FXML
    private TextArea taDetalhes;

    public TelaVisualizarLivros(Biblioteca gerenciador) {
        this.gerenciador = gerenciador;
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @FXML
    void mostrarDetalhes(MouseEvent e) {
        Livro selecionado = (Livro) lstLivros.getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            return;
        }


        String relatorio = "ID: " + selecionado.getId() + "\n"
            + "Titulo: " + selecionado.getTitulo() + "\n"
            + "Editora: " + selecionado.getEditora() + "\n"
            + "Autor: " + selecionado.getAutor() + "\n"
            + "Ano: " + selecionado.getAno() + "\n";

        if (selecionado.isEmprestado()) {
            relatorio += "Status: Emprestado";
        } else {
            relatorio += "Status: Disponível";
        }

        taDetalhes.setText(relatorio);
    }

    @FXML
    void visualizarAutores() {
        App.popScreen();
        App.pushScreen("VISUALIZAR_AUTORES");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstLivros.getItems().addAll(gerenciador.getLivros());
    }

}
