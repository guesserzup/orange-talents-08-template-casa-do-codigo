package br.com.zupacademy.gabriel.casadocodigo.estado;

import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    private String nome;

    @NotBlank
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converterEmModelo(EntityManager manager) {
        return new Estado(this.nome, manager.find(Pais.class, this.idPais));
    }

}
