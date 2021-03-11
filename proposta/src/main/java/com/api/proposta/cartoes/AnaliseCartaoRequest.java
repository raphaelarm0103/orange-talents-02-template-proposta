package com.api.proposta.cartoes;

import com.api.proposta.solicitante.Proposta;

public class AnaliseCartaoRequest {

    private String documento;

    private String nome;

    private Long idProposta;

    public AnaliseCartaoRequest(String documento, String nome, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }
    @Deprecated
    public AnaliseCartaoRequest() {
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }

}
