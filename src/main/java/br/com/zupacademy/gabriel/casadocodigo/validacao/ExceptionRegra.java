package br.com.zupacademy.gabriel.casadocodigo.validacao;


public class ExceptionRegra extends RuntimeException {

    private final ErroDeFormularioDto erroDeFormularioDto;

    public ExceptionRegra(ErroDeFormularioDto erroDeFormularioDto) {
        this.erroDeFormularioDto = erroDeFormularioDto;
    }

    public ErroDeFormularioDto getObjetoErroDTO() {
        return erroDeFormularioDto;
    }
}