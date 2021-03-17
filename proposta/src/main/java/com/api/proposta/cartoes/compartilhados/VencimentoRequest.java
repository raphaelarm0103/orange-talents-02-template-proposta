package com.api.proposta.cartoes.compartilhados;

public class VencimentoRequest {

    private String diaVencimento;

    public VencimentoRequest(String diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public String getDiaVencimento() {
        return diaVencimento;
    }
}
