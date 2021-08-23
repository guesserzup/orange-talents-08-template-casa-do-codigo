package br.com.zupacademy.gabriel.casadocodigo.validacao;

public class ErroDeFormularioDto {

    private String campo;
    private String valor;
    private String erro;

    public ErroDeFormularioDto(String campo, String valor, String erro) {
        this.campo = campo;
        this.valor = valor;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public String getValor() { return valor; }
}
