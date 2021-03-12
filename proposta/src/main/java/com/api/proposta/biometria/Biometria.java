package com.api.proposta.biometria;

import com.api.proposta.cartoes.Cartao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "biometria")
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cartao cartao;

    private String biometria;

    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public Biometria() {
    }

    public Biometria(Cartao cartao, String biometria) {
        this.cartao = cartao;
        this.biometria = biometria;
    }


    public Long getId() {
        return this.id;
    }

    public String getBiometria() {
        return this.biometria;
    }
}
