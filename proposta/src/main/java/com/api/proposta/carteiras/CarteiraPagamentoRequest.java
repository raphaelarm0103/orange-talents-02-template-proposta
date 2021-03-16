package com.api.proposta.carteiras;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraPagamentoRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private TipoCarteira tipoCarteira;

    public CarteiraPagamentoRequest(String email, TipoCarteira tipoCarteira) {
        this.email = email;
        this.tipoCarteira = tipoCarteira;
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }
}
