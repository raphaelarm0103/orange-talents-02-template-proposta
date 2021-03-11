package com.api.proposta.solicitante;

import com.api.proposta.cartoes.Cartao;
import com.api.proposta.cartoes.CartaoRequest;

import javax.persistence.*;
import java.math.BigDecimal;

public class PropostaResponse {

    private String documento;
    private String email;
    private String nome;
    private EnderecoRequest endereco;
    private BigDecimal salario;
    private StatusPropostaEnum status;
    private CartaoRequest cartao;

    public PropostaResponse(Proposta proposta) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.status = status;
        this.cartao = cartao;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusPropostaEnum getStatus() {
        return status;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }
}
