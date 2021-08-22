package br.com.zupacademy.gabriel.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime horarioCadastro;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.horarioCadastro = autor.getHorarioCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getHorarioCadastro() {
        return horarioCadastro;
    }
}
