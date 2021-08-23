package br.com.zupacademy.gabriel.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() { return new Categoria(this.nome); }
}
