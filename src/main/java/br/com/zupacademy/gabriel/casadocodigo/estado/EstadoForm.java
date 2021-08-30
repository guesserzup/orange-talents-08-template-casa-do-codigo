package br.com.zupacademy.gabriel.casadocodigo.estado;

import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoForm {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public Estado toEntity(PaisRepository repository) {
        Optional<Pais> pais = repository.findById(paisId);
        if (pais.isEmpty()) throw new IllegalArgumentException();
        return new Estado(this.nome, pais.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

}
