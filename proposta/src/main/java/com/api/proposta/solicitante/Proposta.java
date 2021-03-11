package com.api.proposta.solicitante;

import com.api.proposta.cartoes.AnaliseCartaoRequest;
import com.api.proposta.cartoes.Cartao;
import com.api.proposta.cartoes.CartaoRequest;
import com.api.proposta.solicitante.analise.AnalisePropostaRequest;
import com.api.proposta.solicitante.analise.AnalisePropostasEnum;
import com.api.proposta.validadores.CNPJouCPF;
import com.api.proposta.validadores.ValorUnico;
import org.springframework.util.Assert;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

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

    @NotNull @Positive
    private BigDecimal salario;

    @Enumerated(EnumType.STRING)
    private StatusPropostaEnum status;

    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    public Proposta(String documento, String email, String nome,  Endereco endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;

        Assert.isTrue(!documento.isBlank(), "O documento precisa ser preenchido");
        Assert.isTrue(!email.isBlank(), "O email precisa ser preenchido");
        Assert.isTrue(!nome.isBlank(), "O nome precisa ser preenchido");

    }
    @Deprecated
    public Proposta() {
    }

    public Long getId() {
        return this.id;
    }

    public StatusPropostaEnum getStatus() {
        return status;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public void setPropostaStatus(AnalisePropostasEnum status) {
        if(status == AnalisePropostasEnum.COM_RESTRICAO)
            this.status = StatusPropostaEnum.NAO_ELEGIVEL;
         else if (status == AnalisePropostasEnum.SEM_RESTRICAO)
            this.status = StatusPropostaEnum.ELEGIVEL;
    }
    public AnalisePropostaRequest toStatus() {
        return new AnalisePropostaRequest(documento, nome, id);
    }

    /*public boolean isElegivel() {
        return status == StatusPropostaEnum.ELEGIVEL;
    }*/

    public void cartaoResponse(Cartao cartao) {
            this.cartao = cartao;
        }

    public AnaliseCartaoRequest cartaoRequest() {
        return new AnaliseCartaoRequest (documento, nome, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return Objects.equals(id, proposta.id) && Objects.equals(documento, proposta.documento) && Objects.equals(email, proposta.email) && Objects.equals(nome, proposta.nome) && Objects.equals(endereco, proposta.endereco) && Objects.equals(salario, proposta.salario) && status == proposta.status && Objects.equals(cartao, proposta.cartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documento, email, nome, endereco, salario, status, cartao);
    }
}

