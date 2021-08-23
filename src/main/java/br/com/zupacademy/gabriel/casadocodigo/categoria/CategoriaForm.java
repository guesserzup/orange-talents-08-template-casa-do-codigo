package br.com.zupacademy.gabriel.casadocodigo.categoria;

import br.com.zupacademy.gabriel.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() { return new Categoria(this.nome); }
}
