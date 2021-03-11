package com.api.proposta.cartoes;

import com.api.proposta.solicitante.Proposta;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnaliseCartaoResponse {

    private String id;

    private String idProposta;

    private String titular;

    private LocalDateTime emitidoEm;

    private Double limite;

    public String getId() {
        return this.id;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getTitular() {
        return titular;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public Double getLimite() {
        return limite;
    }

    public Cartao toModel(Proposta proposta){
        return new Cartao(id, emitidoEm, proposta, limite);
    }

    @Override
    public String toString() {
        return "AnaliseCartaoResponse{" +
                "id='" + id + '\'' +
                ", idProposta='" + idProposta + '\'' +
                ", titular='" + titular + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", limite=" + limite +
                '}';
    }
}
