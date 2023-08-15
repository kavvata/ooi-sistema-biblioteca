package ifpr.pgua.eic.biblioteca.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ifpr.pgua.eic.biblioteca.App;
import ifpr.pgua.eic.biblioteca.models.Autor;
import ifpr.pgua.eic.biblioteca.models.Biblioteca;
import ifpr.pgua.eic.biblioteca.models.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class TelaVisualizarAutores implements Initializable{

    private Biblioteca gerenciador;

    @FXML
    private ListView<Autor> lstAutores;
    @FXML
    private TextArea taDetalhes;

    public TelaVisualizarAutores(Biblioteca gerenciador) {
        this.gerenciador = gerenciador;
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @FXML
    void mostrarDetalhes(MouseEvent e) {
        Autor selecionado = (Autor) lstAutores.getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            return;
        }

        ArrayList<Livro> livrosAutor = gerenciador.getLivroAutor(selecionado);

        String relatorio = "ID: " + selecionado.getId() + "\n"
            + "Nome: " + selecionado.getNome()+ "\n"
            + "Email: " + selecionado.getEmail() + "\n\n"
            + "Livros Cadastrados: \n";

        for (Livro livro : livrosAutor) {
            relatorio += "- " + livro.getTitulo() + " ("+livro.getAno()+")\n";
        }

        taDetalhes.setText(relatorio);
    }

    @FXML
    void visualizarLivros(ActionEvent e) {
        App.popScreen();
        App.pushScreen("VISUALIZAR_LIVROS");
    }
    @FXML
    void visualizarLivros() {
        App.popScreen();
        App.pushScreen("VISUALIZAR_LIVROS");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstAutores.getItems().addAll(gerenciador.getAutores());
    }

}
