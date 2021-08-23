package br.com.zupacademy.gabriel.casadocodigo.categoria;

public class CategoriaDto {

    private Long id;
    private String nome;

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
