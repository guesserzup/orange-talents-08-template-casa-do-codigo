package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListaLivroDto {

    private final Long id;
    private final String titulo;

    public ListaLivroDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListaLivroDto> listaConverter(List<Livro> livros) {

        return livros.stream().map(livro -> new ListaLivroDto(livro.getId(),
                livro.getTitulo())).collect(Collectors.toList());
    }
}