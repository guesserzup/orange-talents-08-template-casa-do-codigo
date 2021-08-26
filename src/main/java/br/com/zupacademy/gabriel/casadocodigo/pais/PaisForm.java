package br.com.zupacademy.gabriel.casadocodigo.pais;

import br.com.zupacademy.gabriel.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais modelConverter() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
