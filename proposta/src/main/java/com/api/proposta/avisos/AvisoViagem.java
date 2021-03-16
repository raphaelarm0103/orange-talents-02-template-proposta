package com.api.proposta.avisos;


import com.api.proposta.cartoes.Cartao;
import org.springframework.context.annotation.DependsOn;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="avisos")
public class AvisoViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;

    private LocalDate terminoViagem;

    @ManyToOne
    private Cartao cartao;

    @Column(updatable = false)
    private LocalDateTime instanteAviso = LocalDateTime.now();

    private String ipCliente;

    private String userAgent;

    public AvisoViagem(LocalDate validoAte, String destino, Cartao cartao) {
        this.terminoViagem = validoAte;
        this.destino = destino;
        this.cartao = cartao;
    }

    @Deprecated
    public AvisoViagem() {
    }

    public AvisoViagem(AvisoViagemRequest avisoViagemRequest, String requestInfo, String agent, Cartao cartao){
        this.destino = avisoViagemRequest.getDestino();
        this.ipCliente = requestInfo;
        this.userAgent = agent;
        this.cartao = cartao;
        this.terminoViagem = avisoViagemRequest.getTerminoViagem();

    }

    public Long getId() {
        return id;
    }

    public LocalDate getTerminoViagem() {
        return terminoViagem;
    }

    public String getDestino() {
        return destino;
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

    public LocalDateTime getInstanteAviso() {
        return instanteAviso;
    }
}
