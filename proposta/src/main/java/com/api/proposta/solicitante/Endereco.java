package com.api.proposta.solicitante;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {

    @NotBlank
    private  String logradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String cep;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    public EnderecoRequest criaEndereco() {
        return new EnderecoRequest(logradouro, numero, cep);
    }
}
