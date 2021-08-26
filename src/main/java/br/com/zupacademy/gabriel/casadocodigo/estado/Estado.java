package br.com.zupacademy.gabriel.casadocodigo.estado;

import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
