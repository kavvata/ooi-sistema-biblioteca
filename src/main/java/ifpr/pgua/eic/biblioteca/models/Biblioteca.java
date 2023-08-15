package ifpr.pgua.eic.biblioteca.models;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> livros;
    private ArrayList<Autor> autores;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
    }

    private void criaFakes() {
        cadastrarAutor("Joao", "joao@teste.com");
        cadastrarAutor("Maria", "maria@teste.com");
        cadastrarAutor("Ze", "ze@teste.com");

        cadastrarLivro("Livro 1", "IFPR", 2020, autores.get(0));
        cadastrarLivro("Livro 2", "IFPR", 2021, autores.get(0));
        cadastrarLivro("Livro 3", "IFPR", 2020, autores.get(1));
        cadastrarLivro("Livro 4", "IFPR", 2022, autores.get(1));
        cadastrarLivro("Livro 5", "IFPR", 2023, autores.get(2));
    }

    public boolean cadastrarLivro(String titulo, String editora, int anoPublicacao, Autor autor) {
        Livro resultadoBusca = buscarLivro(titulo);

        if (resultadoBusca != null) {
            return false;
        }

        Livro novoLivro = new Livro(getIdLivreLivro(), titulo, editora, anoPublicacao, autor);
        livros.add(novoLivro);
        return true;
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public int cadastrarAutor(String nome, String email) {

        if (buscarAutorNome(nome) != null) {
            return 1;
        }
        if (buscarAutorEmail(email) != null) {
            return 2;
        }

        Autor novoAutor = new Autor(getIdLivreAutor(), nome, email);
        autores.add(novoAutor);
        return 0;
    }

    public Autor buscarAutorNome(String nome) {
        for (Autor autor : autores) {
            if (autor.getNome().equals(nome)) {
                return autor;
            }
        }

        return null;
    }

    public Autor buscarAutorEmail(String email) {
        for (Autor autor : autores) {
            if (autor.getEmail().equals(email)) {
                return autor;
            }
        }

        return null;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Livro> getLivroAutor(Autor autor) {
        ArrayList<Livro> livrosEcontrados = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getAutor() == autor) {
                livrosEcontrados.add(livro);
            }
        }

        return livrosEcontrados;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        ArrayList<Livro> livrosEcontrados = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.isEmprestado()) {
                livrosEcontrados.add(livro);
            }
        }

        return livrosEcontrados;
    }

    public ArrayList<Livro> getLivrosDisponiveis() {
        ArrayList<Livro> livrosEcontrados = new ArrayList<>();

        for (Livro livro : livros) {
            if (!livro.isEmprestado()) {
                livrosEcontrados.add(livro);
            }
        }

        return livrosEcontrados;
    }

    public boolean emprestarLivro(Livro livro) {
        if (livro.isEmprestado()) {
            return false;
        }

        livro.setEmprestado(true);
        return true;
    }

    public boolean devolverLivro(Livro livro) {
        if (!livro.isEmprestado()) {
            return false;
        }

        livro.setEmprestado(false);
        return true;
    }

    private int getIdLivreAutor() {
        return autores.size();
    }

    private int getIdLivreLivro() {
        return livros.size();
    }
}
