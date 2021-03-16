package com.api.proposta.cartoes;

import com.api.proposta.bloqueio.Bloqueio;
import com.api.proposta.carteiras.Carteira;
import com.api.proposta.carteiras.CarteiraPagamentoResponse;
import com.api.proposta.solicitante.Proposta;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cartoes")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;

    @JsonFormat(pattern = "yyy-MM-dd@HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime emitidoEm = LocalDateTime.now();

    @OneToOne
    private Proposta proposta;

    private Double limite;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Bloqueio> bloqueios;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Carteira> carteiras;

    public Cartao(String numeroCartao, LocalDateTime emitidoEm, Proposta proposta, Double limite) {
        this.numeroCartao = numeroCartao;
        this.emitidoEm = emitidoEm;
        this.proposta = proposta;
        this.limite = limite;
    }

    @Deprecated
    public Cartao() {
    }

    public CartaoRequest criaCartao() {
        return new CartaoRequest(numeroCartao, emitidoEm, proposta, limite);
    }

    public String getNumeroCartao() {
        return this.numeroCartao;
    }

    public void addBloqueio(Bloqueio bloqueio) {
        this.bloqueios.add(bloqueio);
    }

    public void adicionaCarteira(Carteira carteira) {this.carteiras.add(carteira);
    }
}
