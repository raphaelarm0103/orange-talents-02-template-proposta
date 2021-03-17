package com.api.proposta.cartoes.compartilhados;

import com.api.proposta.cartoes.Cartao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Vencimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diaVencimento;

    @ManyToOne
    private Cartao cartao;

    public Vencimento(String diaVencimento, Cartao cartao) {
        this.diaVencimento = diaVencimento;
        this.cartao = cartao;
    }

    public String getDiaVencimento() {
        return diaVencimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
