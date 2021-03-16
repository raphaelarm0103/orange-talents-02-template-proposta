package com.api.proposta.bloqueio;


import com.api.proposta.cartoes.Cartao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "bloqueios")
public class Bloqueio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idExterno;

    private LocalDateTime bloqueadoEm = LocalDateTime.now();

    private String sistemaResponsavel;

    @ManyToOne
    private Cartao cartao;

    private String ipCliente;

    private String userAgent;

    @Deprecated
    public Bloqueio() {
    }

    public Bloqueio(String idExterno, LocalDateTime bloqueadoEm, String sistemaResponsavel, Cartao cartao, String ipCliente, String userAgent) {
        this.idExterno = idExterno;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.cartao = cartao;
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public Long getId() {
        return id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setInformacoesDeRequest(String remoteAddr, String agent, Cartao cartao) {

        this.ipCliente = remoteAddr;
        this.userAgent = agent;
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Bloqueio{" +
                "id=" + id +
                ", idExterno='" + idExterno + '\'' +
                ", bloqueadoEm=" + bloqueadoEm +
                ", sistemaResponsavel='" + sistemaResponsavel + '\'' +
                ", cartao=" + cartao +
                ", ipCliente='" + ipCliente + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
