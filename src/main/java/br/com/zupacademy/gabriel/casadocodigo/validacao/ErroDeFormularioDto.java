package br.com.zupacademy.gabriel.casadocodigo.validacao;

public class ErroDeFormularioDto {

    private String campo;
    private Object valor;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public Object getValor() { return valor; }
}
