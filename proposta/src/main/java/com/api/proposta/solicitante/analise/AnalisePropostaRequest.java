package com.api.proposta.solicitante.analise;

import com.api.proposta.solicitante.Proposta;

public class AnalisePropostaRequest {

    private String documento;

    private String nome;

    private Long idProposta;

    public AnalisePropostaRequest(String documento, String nome, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
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
