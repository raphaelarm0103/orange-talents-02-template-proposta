package com.api.proposta.bloqueio;

import com.api.proposta.cartoes.Cartao;

import java.time.LocalDateTime;

public class BloqueioResponse {
    private String id;

    private String bloqueadoEm;

    private String sistemaResponsavel;

    private boolean ativo;

    private Cartao cartao;

    public Bloqueio toModel() {
        return new Bloqueio(id, LocalDateTime.parse(bloqueadoEm), sistemaResponsavel, cartao, toModel().getIpCliente(), toModel().getUserAgent());
    }

    public String getId() {
        return id;
    }

    public String getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
