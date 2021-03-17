package com.api.proposta.cartoes.compartilhados;

import com.api.proposta.cartoes.Cartao;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "parcelas")
public class Parcelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificadorDaFatura;

    private int quantidade;

    private BigDecimal valor;

    @ManyToOne
    private Cartao cartao;

    public Parcelas() {
    }

    public Parcelas(String identificadorDaFatura, int quantidade, BigDecimal valor) {
        this.identificadorDaFatura = identificadorDaFatura;
        this.quantidade = quantidade;
        this.valor = valor;
    }


}
