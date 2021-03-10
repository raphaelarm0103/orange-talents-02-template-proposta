package com.api.proposta.solicitante.analise;

public class AnalisePropostaResponse {

    private AnalisePropostasEnum resultadoSolicitacao;

    public AnalisePropostaResponse(AnalisePropostasEnum resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public AnalisePropostasEnum getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public AnalisePropostaResponse() {
    }
}
