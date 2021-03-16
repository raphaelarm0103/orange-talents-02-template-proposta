package com.api.proposta.carteiras;


import com.api.proposta.cartoes.Cartao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "carteiras")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String idExterno;

    @ManyToOne
    private Cartao cartao;

    private String email;

    @Enumerated(EnumType.STRING)
    private TipoCarteira tipoCarteira;

    private LocalDateTime inseridoEm = LocalDateTime.now();

    @Deprecated
    public Carteira() {
    }

    public Carteira(@NotBlank @NotNull String idExterno, Cartao cartao, String email, TipoCarteira tipoCarteira, LocalDateTime inseridoEm) {
        this.idExterno = idExterno;
        this.cartao = cartao;
        this.email = email;
        this.tipoCarteira = tipoCarteira;
        this.inseridoEm = inseridoEm;
    }

    public Long getId() {
        return id;
    }

    public String getIdExterno() {
        return idExterno;
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

    public LocalDateTime getInseridoEm() {
        return inseridoEm;
    }

}
