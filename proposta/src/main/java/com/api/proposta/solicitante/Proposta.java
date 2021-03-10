package com.api.proposta.solicitante;

import com.api.proposta.solicitante.analise.AnalisePropostasEnum;
import org.springframework.util.Assert;


import javax.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private StatusPropostaEnum status;

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

    public void setStatus(StatusPropostaEnum resultadoSolicitacao) {
        this.status = resultadoSolicitacao;
    }
}
