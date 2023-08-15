package ifpr.pgua.eic.biblioteca.models;


public class Livro {
    private int id;
    private String titulo;
    private String editora;
    private int ano;
    private Autor autor;
    private boolean emprestado;

    public Livro(int id, String titulo, String editora, int ano, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        this.autor = autor;
        emprestado = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String toString(){

        /////////////////////////////////////////////////////////////
        // return "id: " + id + "; Titulo: " + titulo              //
        //     + "; Editora: " + editora                           //
        //     + "; Ano: " + ano + "; Autor: "  + autor.getNome(); //
        /////////////////////////////////////////////////////////////

        return titulo;
    }
    
}
