package com.api.proposta.cartoes;

import com.api.proposta.solicitante.Proposta;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class CartaoRequest {

    private String numeroCartao;

    @JsonFormat(pattern = "yyy-MM-dd@HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime emitidoEm = LocalDateTime.now();


    private Proposta proposta;

    private Double limite;

    public CartaoRequest(String numeroCartao, LocalDateTime emitidoEm, Proposta proposta, Double limite) {
        this.numeroCartao = numeroCartao;
        this.emitidoEm = emitidoEm;
        this.proposta = proposta;
        this.limite = limite;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public Double getLimite() {
        return limite;
    }
}
