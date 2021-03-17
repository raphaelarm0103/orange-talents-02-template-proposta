package com.api.proposta.cartoes.compartilhados;

import com.api.proposta.cartoes.Cartao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "renegociacoes")
public class Renegociacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificadorDaFatura;

    private int quantidade;

    private BigDecimal valor;

    private LocalDateTime diaVencimento = LocalDateTime.now();

    @ManyToOne
    private Cartao cartao;

    public Renegociacao(String identificadorDaFatura, int quantidade, BigDecimal valor, Cartao cartao) {
        this.identificadorDaFatura = identificadorDaFatura;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cartao = cartao;
    }

    @Deprecated
    public Renegociacao() {

    }
}
