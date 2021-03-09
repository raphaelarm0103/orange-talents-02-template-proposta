package com.api.proposta.solicitante;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {

    @NotBlank
    private  String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String cep;

    public EnderecoRequest(@NotBlank String logradouro, @NotBlank String numero, @NotBlank String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    public Endereco criaEndereco() {
        return new Endereco(logradouro, numero, cep);
    }
}
