package com.api.proposta.biometria;

public class BiometriaResponse {

    private Long id;

    private String biometria;

    public BiometriaResponse(Biometria biometria) {
        this.id = biometria.getId();
        this.biometria = biometria.getBiometria();
    }
    @Deprecated
    public BiometriaResponse() {

    }

    public Long getId() {
        return id;
    }

    public String getBiometria() {
        return biometria;
    }
}
