package ifpr.pgua.eic.biblioteca.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import ifpr.pgua.eic.biblioteca.models.Autor;
import ifpr.pgua.eic.biblioteca.models.Livro;

public class Leitor {


    public ArrayList<Livro> lerLivros(String nomeArquivo, ArrayList<Autor> autores){
        ArrayList<Livro> listaLivros = new ArrayList<>();

        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while (linha != null) {
                String[] tokens = linha.split(";");

                int id = Integer.valueOf(tokens[0]);
                String titulo = tokens[1];
                String editora = tokens[2];
                int ano = Integer.valueOf(tokens[3]);
                int autorId = Integer.valueOf(tokens[4]);
                boolean emprestado = Boolean.valueOf(tokens[5]);

                listaLivros.add(new Livro(id, titulo, editora, ano, autores.get(autorId)));

                if (emprestado)  {
                    listaLivros.get(listaLivros.size() - 1).setEmprestado(true);
                }

                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return listaLivros;
    }

    public ArrayList<Autor> lerAutores(String nomeArquivo){
        ArrayList<Autor> lista = new ArrayList<>();

        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while (linha != null) {
                String[] tokens = linha.split(";");

                int id = Integer.valueOf(tokens[0]);
                String nome = tokens[1];
                String email = tokens[2];

                lista.add(new Autor(id, nome, email));
                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return lista;

    }

}
