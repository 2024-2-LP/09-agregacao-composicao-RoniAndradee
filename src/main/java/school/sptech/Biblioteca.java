package school.sptech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<Livro>();

    public Biblioteca() {
    }

    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null && livro.getTitulo() != null && !livro.getTitulo().isBlank() && livro.getAutor() != null && !livro.getAutor().isBlank() && livro.getDataPublicacao() != null) {
            this.livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo) {
        for (int i = 0; i < livros.size(); i++){
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(i);
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
         if (titulo != null && !titulo.isBlank()) {
             for (Livro livro : livros) {
                 if(livro.getTitulo().equalsIgnoreCase(titulo)) {
                     return livro;
                 }
             }
         }

         return null;
    }

    public Integer contarLivros() {
        return this.livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for(Livro livro : livros) {
            if(livro.getDataPublicacao().getYear() <= ano){
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

    public List<Livro> retornarTopCincoLivros() {
        return livros.stream()
                .sorted(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed())
                .limit(5)
                .toList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
