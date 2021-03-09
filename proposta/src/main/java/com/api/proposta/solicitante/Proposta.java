package com.api.proposta.solicitante;

import com.api.proposta.validadores.CNPJouCPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "propostas")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String documento;

    private String email;

    private String nome;

    @Embedded
    private Endereco endereco;

    private BigDecimal salario;

    public Proposta(String documento, String email, String nome,  Endereco endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    @Deprecated
    public Proposta() {

    }

    public Long getId() {
        return this.id;
    }
}
