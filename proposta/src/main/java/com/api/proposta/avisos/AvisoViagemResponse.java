package com.api.proposta.avisos;

import com.api.proposta.cartoes.Cartao;

import java.time.LocalDate;

public class AvisoViagemResponse {

    private String terminoViagem;

    private String destino;

    private Cartao cartao;

    public AvisoViagem toModel(){
        return new AvisoViagem(LocalDate.parse(terminoViagem), destino, cartao);
    }

    public String getTerminoViagem() {
        return terminoViagem;
    }

    public String getDestino() {
        return destino;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
