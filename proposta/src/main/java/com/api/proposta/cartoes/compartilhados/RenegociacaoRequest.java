package com.api.proposta.cartoes.compartilhados;

import java.math.BigDecimal;

public class RenegociacaoRequest {

    private String identificadorDaFatura;

    private int quantidade;

    private BigDecimal valor;

    public RenegociacaoRequest(String identificadorDaFatura, int quantidade, BigDecimal valor) {
        this.identificadorDaFatura = identificadorDaFatura;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getIdentificadorDaFatura() {
        return identificadorDaFatura;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
