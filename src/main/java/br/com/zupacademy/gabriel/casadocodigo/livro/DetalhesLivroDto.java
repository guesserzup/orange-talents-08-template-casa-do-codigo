package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.time.LocalDate;
import java.util.HashMap;

public class DetalhesLivroDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numPaginas;
    private String isbn;
    private LocalDate dataRelease;

    private HashMap<String,String> autor = new HashMap<>();

    public DetalhesLivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.isbn = livro.getIsbn();
        this.dataRelease = livro.getDataRelease();
        this.autor.put("nome",livro.getAutor().getNome());
        this.autor.put("descricao",livro.getAutor().getDescricao());
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataRelease() {
        return dataRelease;
    }

    public HashMap<String, String> getAutor() {
        return autor;
    }
}
