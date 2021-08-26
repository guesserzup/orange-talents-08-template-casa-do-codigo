package br.com.zupacademy.gabriel.casadocodigo.pais;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToMany
    private List<Estado> estadoList;

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }
}
