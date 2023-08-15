package ifpr.pgua.eic.biblioteca;

import java.util.ArrayList;

import ifpr.pgua.eic.biblioteca.controllers.TelaCadastro;
import ifpr.pgua.eic.biblioteca.controllers.TelaCadastroAutor;
import ifpr.pgua.eic.biblioteca.controllers.TelaCadastroLivro;
import ifpr.pgua.eic.biblioteca.controllers.TelaEmprestimo;
import ifpr.pgua.eic.biblioteca.controllers.TelaPrincipal;
import ifpr.pgua.eic.biblioteca.controllers.TelaVisualizarAutores;
import ifpr.pgua.eic.biblioteca.controllers.TelaVisualizarLivros;
import ifpr.pgua.eic.biblioteca.infra.Escritor;
import ifpr.pgua.eic.biblioteca.infra.Leitor;
import ifpr.pgua.eic.biblioteca.models.Autor;
import ifpr.pgua.eic.biblioteca.models.Biblioteca;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;


/*A classe App extende a classe BaseAppNavigator, o que
 * permite fazer a navegação entre telas.
 */
public class App extends BaseAppNavigator{


    /*gerenciador da escola que será compartilhado com as diferentes telas
     * da aplicação.
     */
    private Biblioteca gerenciador;


    /*método utilizado para inicializar dependências da aplicação. Este
     * método é executado sempre uma vez no início da aplicação.
     */
    @Override
    public void init() throws Exception {
        super.init();
        Leitor leitor = new Leitor();
        
        gerenciador = new Biblioteca();

        ArrayList<Autor> listaAutores = leitor.lerAutores("autores.txt");
        gerenciador.setAutores(listaAutores);
        gerenciador.setLivros(leitor.lerLivros("livros.txt", listaAutores));
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Escritor escritor = new Escritor();

        escritor.salvarAutores("autores.txt", gerenciador.getAutores());
        escritor.salvarLivros("livros.txt", gerenciador.getLivros());
    }

    /*método para indicar qual é a tela inicial da aplicação */
    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    /*método para indicar o nome da aplicação */
    @Override
    public String getAppTitle() {
        return "Sistema Biblioteca";
    }

    /*método para registrar as telas da aplicação*/
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL",
                      new ScreenRegistryFXML(App.class, 
                                         "principal.fxml", 
                                          o->new TelaPrincipal()));

        registraTela("CADASTRO",
                      new ScreenRegistryFXML(App.class,
                                             "cadastro.fxml",
                                            o->new TelaCadastro()));
        registraTela("CADASTRO_AUTOR", 
                      new ScreenRegistryFXML(App.class, 
                                             "cadastro_autor.fxml",
                                            o->new TelaCadastroAutor(gerenciador)));

        registraTela("CADASTRO_LIVRO", new ScreenRegistryFXML(App.class,
                                                              "cadastro_livro.fxml",
                                                              o-> new TelaCadastroLivro(gerenciador)));
        registraTela("VISUALIZAR_AUTORES",
                     new ScreenRegistryFXML(App.class, 
                                           "visualizar_autores.fxml",
                                            o->new TelaVisualizarAutores(gerenciador)));

        registraTela("VISUALIZAR_LIVROS",
                     new ScreenRegistryFXML(App.class,
                                            "visualizar_livros.fxml",
                                            o -> new TelaVisualizarLivros(gerenciador)));
    
        registraTela("EMPRESTIMO",
                     new ScreenRegistryFXML(App.class,
                                            "emprestimo.fxml",
                                            o -> new TelaEmprestimo(gerenciador)));
        }
}
