package br.com.zupacademy.gabriel.casadocodigo.cliente;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.gabriel.casadocodigo.validacao.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public class ClienteForm {


    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfCnpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private Long paisId;

    @NotBlank
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente toEntity(EstadoRepository estadoRepository, PaisRepository paisRepository) {

        Cliente cliente;
        Optional<Pais> pais = paisRepository.findById(this.paisId);

        if (pais.isEmpty()) {
            throw new ExceptionRegra(new ErroDeFormularioDto("paisId", "Não existe um país com esse id."));
        }

        List<Estado> listaEstados = estadoRepository.findByPaisId(this.paisId);

        if (!listaEstados.isEmpty()) {
            if (this.estadoId == null) {
                throw new ExceptionRegra(new ErroDeFormularioDto("estadoId",
                        "O país " + pais.get().getNome() + " " + "tem um estado, por favor escolha um!"));
            }

            Optional<Estado> estado = estadoRepository.findById(this.estadoId);

            if (estado.isEmpty()) {
                throw new ExceptionRegra(new ErroDeFormularioDto("estadoId", "Não existe um estado com esse id" + "."));
            }

            // Construtor cliente com estado.
            cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                    this.complemento, this.cidade, pais.get(), estado.get(), this.telefone, this.cep);

        } else {

            // Construtor cliente sem estado.
            cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                    this.complemento, this.cidade, pais.get(), this.telefone, this.cep);
        }

        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Long getIdPais() {
        return paisId;
    }

    public Long getIdEstado() {
        return estadoId;
    }
}