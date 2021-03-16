package com.api.proposta.carteiras;

import com.api.proposta.cartoes.Cartao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CarteiraPagamentoResponse {


    private String id;

    private Cartao cartao;

    private String email;

    private TipoCarteira tipoCarteira;

    private LocalDateTime inserioEm = LocalDateTime.now();

    public Carteira toModel(Cartao cartao){
        return new Carteira(id, cartao, email, tipoCarteira, inserioEm);
    }

    public Carteira toModel(){
        return new Carteira(id, cartao, email, tipoCarteira, inserioEm);
    }

    public CarteiraPagamentoResponse(String idExterno, Cartao cartao, String email, TipoCarteira tipoCarteira, LocalDateTime inserioEm) {
        this.id = idExterno;
        this.cartao = cartao;
        this.email = email;
        this.tipoCarteira = tipoCarteira;
        this.inserioEm = inserioEm;
    }

    public String getIdExterno() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }

    public LocalDateTime getInserioEm() {
        return inserioEm;
    }
}
