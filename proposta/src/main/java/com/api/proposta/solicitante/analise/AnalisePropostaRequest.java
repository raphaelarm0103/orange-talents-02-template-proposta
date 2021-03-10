package com.api.proposta.solicitante.analise;

import com.api.proposta.solicitante.Proposta;

public class AnalisePropostaRequest {

    private String documento;

    private String nome;

    private Long idProposta;

    public AnalisePropostaRequest(Proposta proposta){
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
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
