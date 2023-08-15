package ifpr.pgua.eic.biblioteca.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.biblioteca.App;
import ifpr.pgua.eic.biblioteca.models.Biblioteca;
import ifpr.pgua.eic.biblioteca.models.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;

public class TelaEmprestimo implements Initializable {

    Biblioteca gerenciador;

    @FXML
    private ListView<Livro> lstDisponiveis;

    @FXML
    private ListView<Livro> lstEmprestados;

    @FXML
    private Button btMudarEstado;

    public TelaEmprestimo(Biblioteca gerenciador) {
        this.gerenciador = gerenciador;
    }


    @FXML
    void selecionaDisponivel(MouseEvent event) {
        btMudarEstado.setText("Emprestar");
        btMudarEstado.setOnAction(this::emprestar);
    }

    @FXML
    void selecionaEmprestado(MouseEvent event) {
        btMudarEstado.setText("Devolver");
        btMudarEstado.setOnAction(this::devolver);
    }

    @FXML
    void emprestar(ActionEvent e) {
        Livro selecionado = lstDisponiveis.getSelectionModel().getSelectedItem();

        gerenciador.emprestarLivro(selecionado);
        mostraSucesso("Emprestimo realizado com sucesso.");

        atualizaTela();

    }

    @FXML
    void devolver(ActionEvent e) {
        Livro selecionado = lstEmprestados.getSelectionModel().getSelectedItem();
        gerenciador.devolverLivro(selecionado);

        mostraSucesso("Devolução realizada com sucesso.");
        atualizaTela();

    }

    private void atualizaTela() {
        lstEmprestados.getItems().clear();
        lstEmprestados.getItems().addAll(gerenciador.getLivrosEmprestados());

        lstDisponiveis.getItems().clear();
        lstDisponiveis.getItems().addAll(gerenciador.getLivrosDisponiveis());
    }

    private void mostraSucesso(String mensagem) {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setHeaderText("Sucesso");
            a.setContentText(mensagem);
            a.showAndWait();
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstEmprestados.getItems().addAll(gerenciador.getLivrosEmprestados());
        lstDisponiveis.getItems().addAll(gerenciador.getLivrosDisponiveis());
    }

}
