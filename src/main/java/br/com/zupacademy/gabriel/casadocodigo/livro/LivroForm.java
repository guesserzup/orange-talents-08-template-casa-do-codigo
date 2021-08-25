package br.com.zupacademy.gabriel.casadocodigo.livro;

import br.com.zupacademy.gabriel.casadocodigo.autor.Autor;
import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gabriel.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.gabriel.casadocodigo.validacao.UniqueValue;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private Double preco;

    @NotNull
    @Min(100)
    private Integer numPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    private LocalDate dataRelease;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public Livro toEntity(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autor = autorRepository.findById(idAutor);
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);

        if (!autor.isPresent() || !categoria.isPresent()) throw new IllegalArgumentException();
        Livro livro = new Livro(this.titulo, this.resumo, this.preco, this.numPaginas, this.isbn, categoria.get(),
                autor.get(), this.sumario, this.dataRelease);
        return livro;
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}