package ifpr.pgua.eic.biblioteca.infra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import ifpr.pgua.eic.biblioteca.models.Autor;
import ifpr.pgua.eic.biblioteca.models.Livro;

public class Escritor {
    
    

    public boolean salvarLivros(String nomeArquivo,ArrayList<Livro> lista){
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Livro l : lista) {
                String linha = String.join(";", l.getId()+"", l.getTitulo(), l.getEditora(), l.getAno()+"", l.getAutor().getId()+"", l.isEmprestado()+"");
                bw.write(linha);
                bw.newLine();
            }

            bw.close();
            fw.close();
            return true;

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean salvarAutores(String nomeArquivo,ArrayList<Autor> lista){
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Autor a : lista) {
                String linha = String.join(";", a.getId()+"", a.getNome(), a.getEmail());
                bw.write(linha);
                bw.newLine();
            }

            bw.close();
            fw.close();
            return true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
