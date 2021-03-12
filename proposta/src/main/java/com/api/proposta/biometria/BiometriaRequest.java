package com.api.proposta.biometria;

import com.api.proposta.cartoes.Cartao;

import javax.validation.constraints.NotBlank;

public class BiometriaRequest {

    @NotBlank
    private String biometria;

    public String getBiometria() {
        return biometria;
    }

    public Biometria toModel(Cartao cartao) {
        return new Biometria(cartao, biometria);
    }


}
