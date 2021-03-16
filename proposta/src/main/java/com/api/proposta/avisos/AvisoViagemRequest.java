package com.api.proposta.avisos;

import com.api.proposta.cartoes.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvisoViagemRequest {


    private String destino;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate terminoViagem;

    public String getDestino() {
        return destino;
    }

    public LocalDate getTerminoViagem() {
        return terminoViagem;
    }

    public AvisoViagem toModel(Cartao cartao, String requestInfo, String agent){
        return new AvisoViagem(this, requestInfo, agent, cartao);
    }

}
